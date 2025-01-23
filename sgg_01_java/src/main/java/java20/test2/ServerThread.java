package java20.test2;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            User user = (User)ois.readObject();
            ResultInfo resultInfo = new ResultInfo();
            if(user.getUserName().equals("Tom")
                    &&user.getUserPwd().equals("123456")){
                resultInfo.setFlag(true);
                resultInfo.setInfo("恭喜你登录成功");
            }else{
                resultInfo.setFlag(false);
                resultInfo.setInfo("用户名或密码错误请重新输入");
            }
            socket.shutdownInput();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(resultInfo);
            oos.flush();
            oos.close();
            socket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
