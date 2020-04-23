package com.gupao.io.nio.disk;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class NIOFirstDemo {

    public static void main(String[] args) {
        //实现一个文件的拷贝
        try {
            //NIO面向通道和缓冲区 channel -> buffer
            FileInputStream fis = new FileInputStream(new File("D:/test.txt"));
            FileOutputStream fos = new FileOutputStream("D:/test_cp.txt");

            FileChannel fin = fis.getChannel();//通过通道读写数据
            FileChannel fout = fos.getChannel();

            //初始化一个缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fin.read(buffer);//将通道数据读取到缓冲区
            buffer.flip();//从读转化为写
            fout.write(buffer);
            buffer.clear();//重置缓冲区

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
