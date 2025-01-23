package java12.test1;

// 自定义受检异常需要自定义异常类继承自Exception
public class StudentAgeException extends Exception{
// 自定义非受检异常需要自定义异常类继承自RuntimeException
// public class StudentAgeException extends RuntimeException{

    public StudentAgeException(){

    }

    public StudentAgeException(String info){
        super(info);
    }

    @Override
    public String getMessage() {// 相比于构造器传递异常信息，getMessage方法拥有更高的优先级
        return "学员年龄必须在20到40之间";
    }
}
