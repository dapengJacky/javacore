package com.gupao.io.nio.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class ServerSocketChannelDemo {

    public static void main(String[] args) {
        try {
            //NIO 有两种模式 -- 阻塞和非阻塞
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));//绑定监听端口8080
            //修改代码
            serverSocketChannel.configureBlocking(false);//默认值为true
            while (true){
                //设置后不阻塞
                SocketChannel socketChannel = serverSocketChannel.accept();//阻塞，等待客户端连接
                //如果代码进入这个位置，说明有连接过来
                if(socketChannel!=null){
                    System.out.println("客户端连接建立:"+socketChannel.getLocalAddress());
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);//非阻塞模式，这里不阻塞
                    System.out.println(new String(buffer.array()));

                    Thread.sleep(5000);
//                    buffer.flip();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("我是服务端ServerSocketChannel".getBytes());
                    byteBuffer.flip();
                    socketChannel.write(buffer);
                }else {
                    Thread.sleep(1000);
                    System.out.println("没有客户端连接过来");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
