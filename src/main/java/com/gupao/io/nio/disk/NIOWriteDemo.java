package com.gupao.io.nio.disk;

import com.gupao.java_core.reflect.ioc.B;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class NIOWriteDemo {

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("D:/nio_demo.txt");
            FileChannel fc = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //向缓冲区存数据
            buffer.put("I'm a NIO program".getBytes());
            buffer.flip();//从读转为写模式
            fc.write(buffer);//写入数据到通道
            buffer.clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
