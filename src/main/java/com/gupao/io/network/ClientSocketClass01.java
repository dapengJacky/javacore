package com.gupao.io.network;

import java.io.*;
import java.net.Socket;

/**
 * @author jacky
 * @description
 * @date 2020/4/22
 */
public class ClientSocketClass01 {

    public static void main(String[] args) {
        final int DEFAULT_PORT=8080;
        final String host="localhost";
        Socket socket=null;
        try {
            //与服务端建立通信
            socket = new Socket(host,DEFAULT_PORT);
            //构建缓冲流发送消息
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("我是客户端client-02"+",my name is tom\n");
            writer.flush();

            //接收服务端消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMsg = reader.readLine();
            System.out.println("服务端发来的消息："+serverMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
