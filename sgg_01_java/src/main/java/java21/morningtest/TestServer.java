package java21.morningtest;

import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(6666);
            while(true){
                Socket socket = ss.accept();
                ServerThread st = new ServerThread(socket);
                st.start();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
