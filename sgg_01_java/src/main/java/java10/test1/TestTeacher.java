package java10.test1;

public class TestTeacher {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Doctor doctor = new Doctor();
        Person person = new Teacher();
        Comparable comparable = new Teacher();
        methodOne(teacher);
        methodOne(doctor);
        methodTwo(teacher);
        // methodTwo(doctor);
    }

    public static void methodOne(Person person){
    }

    public static void methodTwo(Comparable comparable){
    }

}
