package java21.test;

import java.util.List;

public class TestUserService {
    public static void main(String[] args) {
        UserService userService = new UserService();
//        List<User> list = userService.getAllUsers();
//        for (User user : list) {
//            System.out.println(user);
//        }
        System.out.println(userService.checkUserLogin(new User("Jerry","666667")));
    }
}
