package java12.test1;

public class TestThree {
    public static void main(String[] args) {
        try{

        }catch (Exception e){

        }

        try{

        }finally {

        }

        try{
            System.out.println("in try");
            String s = "";
            s.equals("");
            System.out.println("end try");
            // return;
            System.exit(0);// 结束进程
        }catch (Exception e){
            System.out.println("in catch");
            e.printStackTrace();
        }finally {// 无论前面的代码执行有没有异常抛出，都会执行finally块
            System.out.println("in finally");
        }
        System.out.println("程序结束");
    }
}
