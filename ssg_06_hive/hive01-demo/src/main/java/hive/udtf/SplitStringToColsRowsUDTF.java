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
 * select myudtf("hello-5,"world-6","hadoop-7","hive-8", ",","-");
 *
 * hello   5
 * world   6
 * hadoop  7
 * hive    8
 */
public class SplitStringToColsRowsUDTF extends GenericUDTF {

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
        if(structFieldRefs.size()!=3){
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
        structFieldNames.add("num");
        // 用于指定列的类型
        List<ObjectInspector> structFieldObjectInspectors = new ArrayList<>();
        structFieldObjectInspectors.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
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
        String words = args[0].toString();   // "hello-5,"world-6","hadoop-7","hive-8"
        //2.获取第二参数
        String rowSplit = args[1].toString();  //  ","
        //3.获取第三参数
        String colSplit = args[2].toString();  // "-"
        String[] rows = words.split(rowSplit);
        for (String row : rows) {
            String[] cols = row.split(colSplit);
            outs.clear();
            for (String col : cols) {
               outs.add(col);
            }
            forward(outs);
        }
    }

    @Override
    public void close() throws HiveException {

    }
}
