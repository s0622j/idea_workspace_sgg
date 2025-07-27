/**
  数据结构映射
（1）假设某表有如下一行，我们用JSON格式来表示其数据结构。在Hive下访问的格式为
{
    "name": "songsong",
    "friends": ["bingbing" , "lili"] ,       //列表Array,
    "children": {                      //键值Map,
        "xiao song": 19 ,
        "xiaoxiao song": 18
    }
    "address": {                      //结构Struct,
        "street": "hui long guan" ,
        "city": "beijing"
    }
}
（2）基于上述数据结构，我们在Hive里创建对应的表，并导入数据。
在目录/opt/module/hive/datas下创建本地测试文件personInfo.txt
[atguigu@hadoop102 datas]$ vim personInfo.txt
songsong,bingbing_lili,xiao song:18_xiaoxiao song:19,hui long guan_beijing
yangyang,caicai_susu,xiao yang:18_xiaoxiao yang:19,chao yang_beijing
注意：MAP，STRUCT和ARRAY里的元素间关系都可以用同一个字符表示，这里用“_”。
 */

hive
(default)>
create table personInfo
(
    name     string,
    friends  array<string>,
    children map<string, int>,
    address  struct<street:string, city:string>
) row format delimited
fields terminated by ','
collection items terminated by '_'
map keys terminated by ':'
lines terminated by '\n';

-- 指定数据文件中行格式的分隔符
-- 指定字段之间用’,’进行分割
-- 指定集合类型的元素之间用’_’进行分割
-- 指定map类型中key和value用’:’进行分割
-- 指定行之间的分隔符为’\n’

-- 2）上传数据到hdfs中上述表的对应路径下
-- [atguigu@hadoop102 ~]$ hadoop fs  -put /opt/module/hive/datas/personInfo.txt /user/hive/warehouse/personinfo;
-- （3）访问三种集合列里的数据，以下分别是ARRAY，MAP，STRUCT的访问方式
hive (default)>
select
    friends[1],
    children['xiao song'],
    address.city
from personInfo
where name="songsong";


--------------------------------- 管理表(内部表)
-- 案例实操
-- （0）创建数据文件，在/opt/module/hive/datas目录下创建文件student.txt，编辑如下内容：
-- [atguigu@hadoop102 datas]$ vim student.txt
-- 1001	ss1
-- 1002	ss2
-- 1003	ss3
-- 1004	ss4
-- 1005	ss5
-- 1006	ss6
-- 1007	ss7
-- 1008	ss8
-- 1009	ss9
-- （1）创建内部表student
-- hive(default)>
  create table if not exists student_in(
   id int,
   name string
               )
    row format delimited
    fields terminated by '\t'
    stored as textfile
    location '/user/hive/warehouse/student_in';

load data local inpath '/opt/module/hive/datas/student.txt' into table student_in
-- （2）查询表的类型
-- hive (default)> desc formatted student;
-- Table Type:             MANAGED_TABLE
-- （3）根据查询结果创建表（查询的结果会添加到新创建的表中）
-- hive(default)> create table if not exists student2 as select id, name from student;
-- （4）根据已经存在的表结构创建表
-- hive(default)> create table if not exists student3 like student;
-- （5）查询表的类型
-- hive (default)> desc formatted student2;
-- Table Type:             MANAGED_TABLE
-- （6）删除表student2后，观察表的元数据和数据文件是否还存在
-- hive(default)> drop table student2;

--------------------------------- 外部表
-- 1.理论
-- 因为表是外部表，所以Hive并非认为其完全拥有这份数据。
-- 删除该表并不会删除掉这份数据，不过描述表的元数据信息会被删除掉。
-- 2.管理表和外部表的使用场景
-- 每天将收集到的网站日志定期流入HDFS文本文件。
-- 在外部表（原始日志表）的基础上做大量的统计分析，用到的中间表、结果表使用内部表存储，数据通过SELECT+INSERT进入内部表。外部表多用于存储原始数据，为多个部门、小组所使用，采用外部表共易共享数据。
-- 3.案例实操
-- 1）在/opt/module/hive/datas路径上，创建teacher.txt文件，并输入如下内容。
-- 1001	teacher1
-- 1002	teacher2
-- 1003	teacher3
-- 1004	teacher4
-- 1005	teacher5
-- 2）上传数据到HDFS
-- [atguigu@hadoop102 datas]$ hadoop fs -mkdir -p /school/teacher
-- [atguigu@hadoop102 datas]$ hadoop fs -put teacher.txt /school/teacher
-- 3）在hive中创建外部表teacher
-- hive (default)>
create external table if not exists teacher(
    id int,
    name string
)
row format delimited fields terminated by '\t'
location '/school/teacher';
-- 4）查看创建的表
-- hive (default)> show tables;
-- 5）查看表格式化信息
-- hive (default)> desc formatted dept;
-- Table Type:             EXTERNAL_TABLE
-- 6）删除外部表，观察表的元数据和相应hdfs中的数据。
-- hive (default)> drop table dept;
-- 外部表删除后，hdfs中的数据还在，但是metadata中dept的元数据已被删除


------------------------- 管理表与外部表的互相转换
-- （1）查询表的类型
hive (default)> desc formatted student2;
Table Type:             MANAGED_TABLE
-- （2）修改内部表student2为外部表
hive (default)> alter table student2 set tblproperties('EXTERNAL'='TRUE');
-- （3）查询表的类型
hive (default)> desc formatted student2;
Table Type:             EXTERNAL_TABLE
-- （4）修改外部表student2为内部表
hive (default)> alter table student2 set tblproperties('EXTERNAL'='FALSE');
-- （5）查询表的类型
hive (default)> desc formatted student2;
Table Type:             MANAGED_TABLE
-- 注意：('EXTERNAL'='TRUE')和('EXTERNAL'='FALSE')为固定写法，区分大小写！


-- 将查询的结果导出到本地
hive (default)> insert overwrite local directory '/opt/module/hive/datas/export/student'
select * from student;
-- 2）将查询的结果格式化导出到本地
hive(default)> insert overwrite local directory '/opt/module/hive/datas/export/student'
           ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'             select * from bigdata1.student;
-- 3）将查询的结果导出到HDFS上(没有local)
hive (default)> insert overwrite directory '/output/student'
             ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'
select * from student;
-- 注意：insert导出时，hive会自动创建导出目录，但是由于是overwrite，所以导出路径一定要写准确，否则存在误删数据的可能。


数据迁移
-- export和import命令主要用于两个Hadoop平台集群之间Hive表迁移。（元数据源+真实数据）
-- 5.3.1 Export导出到HDFS上
hive(default)> export table default.student2 to '/地址';	导出到哪里
5.3.2 Import数据到指定Hive表中
-- 注意：先用export导出后，再将数据导入。
hive (default)> import table student2  from '/地址 ';		从哪里导入
