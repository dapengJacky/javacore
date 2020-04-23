package com.gupao.io.nio.disk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author jacky
 * @description
 * @date 2020/4/23
 */
public class NIOReadDemo {

    public static void main(String[] args) {
        try {
            //数据来源：本地磁盘
            FileInputStream fis = new FileInputStream(new File("D:/test.txt"));
            //构建通信管道
            FileChannel fc = fis.getChannel();
            //初始化缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            //将数据读取到缓冲区
            while(fc.read(buffer)!=-1){
                System.out.println(new String(buffer.array(), Charset.defaultCharset()));
                buffer.clear();//重置缓冲区数据
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
