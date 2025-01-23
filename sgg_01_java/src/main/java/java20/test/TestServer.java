package java20.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        // 服务器端：客户端与服务器双向单次通讯String
        try{
            ServerSocket ss = new ServerSocket(8888);
            Socket socket = ss.accept();// 监听
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String word = br.readLine();
            System.out.println("这里是服务器，客户端的请求信息是："+word);
            socket.shutdownInput();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("你好，客户端，我是服务器，我收到了你的消息");
            bw.flush();
            bw.close();
            socket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
