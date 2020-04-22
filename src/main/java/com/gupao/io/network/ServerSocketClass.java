package com.gupao.io.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jacky
 * @description
 * @date 2020/4/22
 */
public class ServerSocketClass {

    public static void main(String[] args) {
        final int DEFAULT_PORT=8080;
        ServerSocket serverSocket=null;
        try {
            //在操作系统注册8080监听
            serverSocket = new ServerSocket(DEFAULT_PORT);
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            /*while (true){
                Socket socket = serverSocket.accept();//阻塞，等待客户端连接唤醒
                System.out.println("客户端"+socket.getPort()+"建立连接");
                //构建socket套接字进行通信
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientMsg = bufferedReader.readLine();
                System.out.println("客户端消息："+clientMsg);

                Thread.sleep(10000);//睡眠10s演示客户端请求阻塞
                //响应回复客户端消息
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write("我已接收到你的消息\n");//如果不加换行，默认消息没有发送完毕
                bufferedWriter.flush();
            }*/

            //优化
            while (true){
                Socket socket = serverSocket.accept();
                executorService.submit(new Thread(new ServerThread(socket)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
