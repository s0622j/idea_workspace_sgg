package java21.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public boolean checkUserLogin(User user){
        boolean flag = false;
        List<User> list = getAllUsers();
        for (User currUser : list) {
            if(user.getUserName().equals(currUser.getUserName())
                    &&user.getUserPwd().equals(currUser.getUserPwd())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        try{
            File file = new File("day21\\file\\users.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(true){
                String str = br.readLine();
                if(str == null){
                    break;
                }
                String[] data = str.split("-");
//                User user = new User();
//                user.setUserName(data[0]);
//                user.setUserPwd(data[1]);
                User user = new User(data[0],data[1]);
                list.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
