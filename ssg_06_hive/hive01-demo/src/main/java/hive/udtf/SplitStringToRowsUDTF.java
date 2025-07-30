package hive.udtf;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentLengthException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentTypeException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义UDTF
 *    继承Hive提供的GenericUDTF类
 *
 * select myudtf("hello,world,hadoop,hive", ",");
 */
public class SplitStringToRowsUDTF extends GenericUDTF {

    private List<String> outs = new ArrayList<>();

    /**
     * 初始化方法
     * @param argOIs
     * @return
     * @throws UDFArgumentException
     */
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
        //1.判断参数的个数
        List<? extends StructField> structFieldRefs = argOIs.getAllStructFieldRefs();
        if(structFieldRefs.size()!=2){
            throw new UDFArgumentLengthException("函数的参数个数不正确!!!");
        }
        //2.判断参数的类型
        for (int i = 0; i < structFieldRefs.size(); i++) {
            StructField structFieldRef = structFieldRefs.get(i);
            if(!structFieldRef.getFieldObjectInspector().getCategory().equals(ObjectInspector.Category.PRIMITIVE)){
                throw new UDFArgumentTypeException(i,"函数的参数类型不正确!!!");
            }
        }

        //3.
        // 用于指定列的名字
        List<String> structFieldNames = new ArrayList<>();
        structFieldNames.add("word");
        // 用于指定列的类型
        List<ObjectInspector> structFieldObjectInspectors = new ArrayList<>();
        structFieldObjectInspectors.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(structFieldNames,structFieldObjectInspectors);

    }

    /**
     * 函数的核心处理方法
     * @param args 传入到函数中的参数
     * @throws HiveException
     */
    @Override
    public void process(Object[] args) throws HiveException {
        //1.获取第一参数
        String words = args[0].toString();   //"hello,world,hadoop,hive"
        //2.获取第二参数
        String split = args[1].toString();  // ","
        //3.切割
        String[] splitwords = words.split(split);  //[hello,world,hadoop,hive]
        //4.将每个单词作为一行数据写出
        for (String word : splitwords) {
            outs.clear();
            outs.add(word);
            forward(outs);
        }

    }

    @Override
    public void close() throws HiveException {

    }
}
