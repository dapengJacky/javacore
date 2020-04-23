package com.gupao.io.nio.network;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class SelectorClientDemo {

    static Selector selector;

    public static void main(String[] args) {
        try {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost",8080));
            //注册连接事件
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            while (true){
                selector.select();//阻塞
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if(selectionKey.isConnectable()){//连接事件
                        handleConnect(selectionKey);
                    }else if(selectionKey.isReadable()){//读事件
                        handleRead(selectionKey);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void handleConnect(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if(socketChannel.isConnectionPending()){
            socketChannel.finishConnect();//处理没有连接上服务端的异常
        }
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("hello Server,I'm NIO Client01".getBytes()));
        //注册读事件，读取服务端的消息
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel=(SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.read(buffer);
        System.out.println("Client receive Msg:"+new String(buffer.array()));
    }
}
