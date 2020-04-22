package com.gupao.io.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jacky
 * @description 基于Socket管道进行网络通信
 * @date 2020/4/22
 */
public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();//阻塞，等待客户端连接
        InputStream inputStream = socket.getInputStream();//获取客户端发送的信息
        int len=0;
        byte[] buff = new byte[1024];
        while ((len=inputStream.read(buff))!=-1){
            System.out.println(new String(buff,0,len,"UTF-8"));
        }
        //关闭流
        inputStream.close();
        socket.close();
    }
}
