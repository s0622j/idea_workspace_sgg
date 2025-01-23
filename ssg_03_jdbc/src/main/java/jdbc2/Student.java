package jdbc2;

public class Student {
    private int id;
    private String name;
    private int sid;

    public Student() {
    }

    public Student(int id, String name, int sid) {
        this.id = id;
        this.name = name;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return id + " == " + name + "===" + sid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
