package hive.udf;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentLengthException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentTypeException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

/**
 * 插件性质的开发：
 *   1. 实现接口或者继承类
 *   2. 重写相应的方法
 *   3. 打包
 *
 *
 * 自定义UDF函数类
 *    继承Hive提供的GenericUDF类
 *
 *
 * mylen('abcd') -> 4
 *
 */
public class CalStringLengthUDF extends GenericUDF {
    /**
     * 初始化方法
     * @param arguments  传入到函数中的参数对应的类型的鉴别器对象
     * @return  指定函数的返回值类型对应的鉴别器对象
     * @throws UDFArgumentException
     */
    @Override
    public ObjectInspector initialize(ObjectInspector[] arguments) throws UDFArgumentException {
        //1. 校验函数的参数个数
        if(arguments== null || arguments.length != 1 ){
            throw new UDFArgumentLengthException("函数的参数个数不正确!!!");
        }
        //2. 校验函数的参数类型
        if(!arguments[0].getCategory().equals(ObjectInspector.Category.PRIMITIVE)){
            throw new UDFArgumentTypeException(0,"函数的参数类型不正确!!!");
        }
        //3. 返回函数的返回值类型对应的鉴别器类型
        return PrimitiveObjectInspectorFactory.javaIntObjectInspector;
    }

    /**
     * 函数核心处理方法
     * @param arguments  传入到函数的参数
     * @return  函数的返回值
     * @throws HiveException
     */
    @Override
    public Object evaluate(DeferredObject[] arguments) throws HiveException {
        //1. 获取参数
        Object argument = arguments[0].get() ;
        if(argument == null){
            return 0 ;
        }
        return argument.toString().length();
    }


    @Override
    public String getDisplayString(String[] children) {
        return "";
    }
}
