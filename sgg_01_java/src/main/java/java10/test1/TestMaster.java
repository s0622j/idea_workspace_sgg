package java10.test1;

public class TestMaster {
    public static void main(String[] args) {
        Master master = new Master();
        Teacher teacher = new Teacher();
        Doctor doctor = new Doctor();
        Person person = new Teacher();
        // master.personSayHello(person);// 有名对象传参
        master.personSayHello(new Teacher());// 匿名对象传参
        teacher.sayHello();
        teacher.toString();
    }
}
