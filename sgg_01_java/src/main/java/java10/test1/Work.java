package java10.test1;

import java.util.Objects;

// Comparable接口是让类的对象比较大小的接口
public class Work implements Comparable{
    private String name;
    private int age;
    private String gender;

    public Work() {
    }

    public Work(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Work{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    // 当方法返回负数时代表调用方法的对象小，参数对象大
    // 当方法返回正数时代表调用方法的对象大，参数对象小
    // 返回0时代表两个对象相等
    @Override
    public int compareTo(Object o) {
        Work work = (Work)o;
        return this.getAge() - work.getAge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Work)) return false;
        Work work = (Work) o;
        return getAge() == work.getAge() &&
                getName().equals(work.getName()) &&
                getGender().equals(work.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getGender());
    }
}
