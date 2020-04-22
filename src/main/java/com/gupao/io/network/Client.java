package com.gupao.io.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author jacky
 * @description
 * @date 2020/4/22
 */
public class Client {


    public static void main(String[] args) throws IOException {
        //与服务端建立连接
        Socket socket = new Socket("localhost",8080);
        //通过输出流发送信息到服务端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，hello world".getBytes("UTF-8"));
        //关闭流
        outputStream.close();
        socket.close();
    }
}
