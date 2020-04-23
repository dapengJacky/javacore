package com.gupao.io.nio.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class SelectorServerDemo {

    private static Selector selector;

    public static void main(String[] args) {
        try {
            selector=Selector.open();//创建一个多路复用器
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);//这里必须设置为非阻塞
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            //监听连接事件--在selector上注册一个连接事件
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            while (true){
                selector.select();//阻塞--监听事件是否就绪
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator=selectionKeys.iterator();
                if(iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();//移除防止重复遍历
                    if(selectionKey.isAcceptable()){//连接事件
                        handleAccept(selectionKey);
                    }else if(selectionKey.isReadable()){//可读事件
                        handleRead(selectionKey);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void handleAccept(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel= (ServerSocketChannel)selectionKey.channel();
        //这里一定不会返回null,因为select()方法只有有客户端连接才会释放阻塞
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("hello Client,I'm NIO Server".getBytes()));
        //这里注册的是socketChannel的读事件
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.read(buffer);
        System.out.println("Server receive Msg:"+new String(buffer.array()));
    }


}
