import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentLengthException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentTypeException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;


/**
 * 自定义UDF函数，需要继承GenericUDF类
 * 需求: 计算指定字符串的长度
 */
public class MyStringLength extends GenericUDF {
    /**
     * 初始化方法：检查函数参数个数、类型、返回值类型的检查其
     * @param arguments 输入参数类型的鉴别器对象
     * @return 返回值类型的鉴别器对象
     * @throws UDFArgumentException
     */
    @Override
    public ObjectInspector initialize(ObjectInspector[] arguments) throws UDFArgumentException {
        // 判断输入参数的个数
        if (arguments.length != 1) {
            throw new UDFArgumentLengthException("你看看几个参数！Input Args Length Error!!!");
        }
        // 判断输入参数的类型
        if (!arguments[0].getCategory().equals(ObjectInspector.Category.PRIMITIVE)) {
            throw new UDFArgumentTypeException(0, "你看看啥类型！Input Args Type Error!!!");
        }
        //函数本身返回值为int，需要返回int类型的鉴别器对象
        return PrimitiveObjectInspectorFactory.javaIntObjectInspector;
    }

    /**
     * 函数的逻辑处理
     *
     * @param arguments 输入的参数
     * @return 返回值（即返回长度）
     * @throws HiveException
     */
    @Override
    public Object evaluate(DeferredObject[] arguments) throws HiveException {
        // null值问题
        if (arguments[0].get() == null) {
            return 0;
        }
        return arguments[0].get().toString().length();
    }

    @Override
    public String getDisplayString(String[] children) {
        return "";
    }
}


/**
 * 4）打成jar包上传到服务器/opt/module/hive/datas/myudf.jar
 * 5）将jar包添加到hive的classpath
 * hive (default)> add jar /opt/module/hive/datas/myudf.jar;
 *
 *
 * 8.5 创建临时函数
 * 1.创建临时函数与开发好的java class关联
 * hive (default)> create temporary function my_len as "com.atguigu.hive. MyStringLength";
 * 2.在hql中使用自定义的函数
 * hive (default)> select ename,my_len(ename) ename_len from emp;
 *
 * 注意：临时函数只跟会话有关系，跟库没有关系，只要创建临时函数的会话不断，再当前会话下，任意一个库都可以使用，其他会话全部不能使用。
 * 8.6 创建永久函数
 * 注意：因为add jar的方式本身也是临时生效，所以在创建永久函数的时候，需要执行路径（应且因为元数据的原因，这个路径还得是HDFS上的路径）
 * hive (default)>
 * create function my_len2
 * as "com.atguigu.hive.udf.MyUDF"
 * using jar "hdfs://hadoop102:8020/udf/myudf.jar";
 * 即可在hql中使用自定义的永久函数
 * hive (default)>
 * select
 *     ename,
 *     my_len2(ename) ename_len
 * from emp;
 * 删除永久函数
 * hive (default)> drop function my_len2;
 * 注意：永久函数跟会话没有关系，创建函数的会话断了以后，其他会话也可以使用。
 * 永久函数创建的时候，在函数名之前需要自己加上库名，如果不指定库名的话，会默认把当前库的库名给加上。
 * 永久函数使用的时候，需要在指定的库里面操作,或者在其他库里面使用的话加上 库名.函数名。
 */