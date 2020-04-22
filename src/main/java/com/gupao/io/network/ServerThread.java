package com.gupao.io.network;

import java.io.*;
import java.net.Socket;

/**
 * @author jacky
 * @description
 * @date 2020/4/22
 */
public class ServerThread implements Runnable {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("客户端"+socket.getPort()+"建立连接");
            //构建socket套接字进行通信
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMsg = null;
            clientMsg = bufferedReader.readLine();
            System.out.println("客户端消息："+clientMsg);
            Thread.sleep(10000);//睡眠10s演示客户端请求阻塞
            //响应回复客户端消息
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我已接收到你的消息\n");//如果不加换行，默认消息没有发送完毕
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
