package java18.test1;

public class User {
    private String userName;
    private String userPwd;
    private int userLevel;

    public User() {
    }

    public User(String userName, String userPwd, int userLevel) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userLevel = userLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userLevel=" + userLevel +
                '}';
    }
}
