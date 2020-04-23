package com.gupao.io.nio.network;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class SocketChannelClient {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            //在非阻塞模式下，这行代码不一定是等到连接建立后才往下执行
            socketChannel.connect(new InetSocketAddress("localhost",8080));
            if(socketChannel.isConnectionPending()){
                socketChannel.finishConnect();//如果连接没有建立，此处会抛异常
            }
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("I'm NIO SocketChannel Client01".getBytes());
            buffer.flip();//从读转化为写模式
            socketChannel.write(buffer);

            //接收服务端发送的消息
            buffer.clear();
            int r=socketChannel.read(buffer);//非阻塞模式，这里不阻塞
            if(r>0){
                System.out.println("收到服务端消息："+new String(buffer.array()));
            }else {
                System.out.println("服务端的数据还未返回");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
