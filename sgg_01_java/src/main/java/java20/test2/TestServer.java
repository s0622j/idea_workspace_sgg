package java20.test2;

import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        // 服务器：客户端与服务器双向多次通讯Object
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true) {
                Socket socket = ss.accept();// 监听
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
