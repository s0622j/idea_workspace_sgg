import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentLengthException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两参数
 * 1,字段
 * 2,分隔符
 *
 * select permutation_udtf('17.5(150),17.5(210),9.6',',')
 * permutation              perm_type
 * 17.5(150),17.5(210),9.6   1
 * 17.5(150),9.6,17.5(210)   2
 * 17.5(210),17.5(150),9.6   3
 * 17.5(210),9.6,17.5(150)   4
 * 9.6,17.5(150),17.5(210)   5
 * 9.6,17.5(210),17.5(150)   6
 */
// todo 递归穷举排序 输入多列
public class PermutationUDTF extends GenericUDTF {

    @Override
    public StructObjectInspector initialize(ObjectInspector[] args) throws UDFArgumentException {
        // 参数校验 - 只需要2个字符串参数
        if (args.length != 2) {
            throw new UDFArgumentLengthException("PermutationWithTypeUDTF 只需要2个参数: 数据+分隔");
        }

        // 定义输出结构：两列
        ArrayList<String> fieldNames = new ArrayList<>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<>();

        fieldNames.add("permutation");  // 第一列：排列组合字符串
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        fieldNames.add("perm_type");    // 第二列：排列类型标识
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }

    @Override
    public void process(Object[] args) throws HiveException {
        String input = args[0].toString();
        String split = args[1].toString();

        // 处理空值
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        // 分割字符串
        String[] items = input.trim().split(split);
        //String[] items = input.trim().split("\\s*,\\s*");

        // 生成所有排列组合
        List<List<String>> permutations = generatePermutations(Arrays.asList(items));

        // 输出每种排列组合
        for (int i = 0; i < permutations.size(); i++) {
            String permStr = String.join(",", permutations.get(i));
            forward(new Object[]{
                    permStr,            // 排列后的字符串
                    String.valueOf(i + 1)    // 类型标识(type1, type2,...)
            });
        }
    }

    // 生成全排列的递归方法
    private List<List<String>> generatePermutations(List<String> items) {
        List<List<String>> result = new ArrayList<>();
        if (items.size() == 1) {
            result.add(items);
            return result;
        }

        for (int i = 0; i < items.size(); i++) {
            String current = items.get(i);
            List<String> remaining = new ArrayList<>(items);
            remaining.remove(i);

            for (List<String> permutation : generatePermutations(remaining)) {
                List<String> newPermutation = new ArrayList<>();
                newPermutation.add(current);
                newPermutation.addAll(permutation);
                result.add(newPermutation);
            }
        }
        return result;
    }

    @Override
    public void close() throws HiveException {
        // 清理资源
    }
}