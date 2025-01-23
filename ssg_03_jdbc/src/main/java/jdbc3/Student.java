package jdbc3;

public class Student {
    private int aid;
    private String name;
    private int sid;

    public Student() {
    }

    public Student(int aid, String name, int sid) {
        this.aid = aid;
        this.name = name;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", sid=" + sid +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
