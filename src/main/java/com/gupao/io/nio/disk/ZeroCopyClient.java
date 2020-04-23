package com.gupao.io.nio.disk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class ZeroCopyClient {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost",8080));

            FileChannel fileChannel = new FileInputStream(new File("D:/思维导图.zip")).getChannel();
            //tf表示总的文件字节数
            long size=fileChannel.size();
            long position=0;
            int i=0;
            while (size>0){
                long tf= fileChannel.transferTo(position, size, socketChannel);
                if(tf>0){
                    position+=tf;
                    size-=tf;
                }
                i++;
                System.out.println("第"+i+"次的传输字节数:"+tf);
            }
            //关闭流
            fileChannel.close();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
