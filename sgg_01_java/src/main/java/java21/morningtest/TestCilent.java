package java21.morningtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TestCilent {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",6666);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("你好，服务器，我是客户端，我向你发送了请求");
            bw.flush();
            socket.shutdownOutput();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String answer = br.readLine();
            System.out.println("这里是客户端，服务器的响应求信息是："+answer);
            br.close();
            socket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
