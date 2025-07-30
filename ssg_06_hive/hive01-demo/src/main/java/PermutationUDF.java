import org.apache.hadoop.hive.ql.exec.UDF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三参数
 * 1,字段
 * 2,分隔符
 * 3,最多排序字段个数
 *
 * select permutation_udf('17.5(150),17.5(210),9.6',',','8');
 * ==> 17.5(150):17.5(210):9.6,17.5(150):9.6:17.5(210),17.5(210):17.5(150):9.6,17.5(210):9.6:17.5(150),9.6:17.5(150):17.5(210),9.6:17.5(210):17.5(150)
 */
// todo 递归穷举排序 输出一列
public class PermutationUDF extends UDF {

    // 默认 carTypeNum="7"
    public String  evaluate(String input,String split) {
        return evaluate(input, split,"7");
    }
    public String  evaluate(String input,String split,String carTypeNum) {

        if (input == null) return "";
        // 分割字符串并去除前后空格
        String[] items = input.toString().trim().split(split);
        List<String> itemsList = Arrays.asList(items);
        if(items.length > Integer.parseInt(carTypeNum))  return "";
        // 生成所有排列组合
        List<List<String>> permutations = generatePermutations(itemsList);

        // 将所有排列组合拼接成一个字符串
        StringBuilder result = new StringBuilder();
        // 为每种排列添加编号并格式化为字符串
        for (int i = 0; i < permutations.size(); i++) {
            //String numberedPermutation = (i+1) + ":" + String.join(":", permutations.get(i));
            String numberedPermutation = String.join(":", permutations.get(i));
            result.append(numberedPermutation).append(","); // 每个结果用逗号分隔
        }

        // 去掉最后一个多余的逗号
        String finalResult = result.length() > 0 ? result.substring(0, result.length() - 1) : "";

        return finalResult;
    }

    // 生成所有排列的递归方法
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


    public static void main(String[] args) {
        String testValue = "17.5(150),17.5(210),9.6";
        PermutationUDF permutationUDF = new PermutationUDF();
        System.out.println(permutationUDF.evaluate(testValue,",","3"));
    }
}


