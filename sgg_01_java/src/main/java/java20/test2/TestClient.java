package java20.test2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        // 客户端：客户端与服务器双向多次通讯对象
        try{
            do{
                Socket socket = new Socket("localhost", 8888);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User user = new User();
                Scanner input = new Scanner(System.in);
                System.out.println("请输入用户名：");
                user.setUserName(input.next());
                System.out.println("请输入密码");
                user.setUserPwd(input.next());
                oos.writeObject(user);
                socket.shutdownOutput();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ResultInfo resultInfo = (ResultInfo) ois.readObject();
                System.out.println(resultInfo.getInfo());
                if (resultInfo.isFlag()) {
                    // 登录成功
                    System.out.println("登录成功");
                    break;
                } else {
                    System.out.println("登录失败");
                }
                ois.close();
                socket.close();
            }while(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("程序结束");
    }
}
