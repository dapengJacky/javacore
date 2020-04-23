package com.gupao.io.nio.disk;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class ZeroCopyServer {

    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel=null;
        FileChannel fileChannel=null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            SocketChannel socketChannel = serverSocketChannel.accept();//阻塞，等待客户端连接

            fileChannel = new FileOutputStream("D:/思维导图_cp.zip").getChannel();
            int i=0;
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while ((i=socketChannel.read(buffer))!=-1){
                buffer.flip();
                fileChannel.write(buffer);
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                fileChannel.close();;
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
