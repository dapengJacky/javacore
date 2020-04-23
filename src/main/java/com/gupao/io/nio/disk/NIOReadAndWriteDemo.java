package com.gupao.io.nio.disk;

import java.io.FileInputStream;
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
public class NIOReadAndWriteDemo {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:/nio_demo.txt");
            FileOutputStream fos = new FileOutputStream("D:/demo.txt");

            FileChannel fcin = fis.getChannel();
            FileChannel fcout = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(fcin.read(buffer)!=-1){
                System.out.println("come in to read and write");
                buffer.flip();
                fcout.write(buffer);
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
