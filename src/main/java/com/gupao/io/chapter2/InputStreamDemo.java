package com.gupao.io.chapter2;

import java.io.*;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class InputStreamDemo {


    public static void main(String[] args) throws IOException {
        File file = new File("D:/timg.png");
      /*  //读取磁盘文件到内存中
        FileInputStream fileInputStream = new FileInputStream(file);
        //将内存数据写入到磁盘中
        FileOutputStream fileOutputStream = new FileOutputStream("D:/timg_cp.png");
        int len=0;
        byte[] buffer = new byte[1024];//控制每次写入到磁盘的字节大小
        while ((len=fileInputStream.read(buffer))!=-1){
//            fileOutputStream.write(len);
            fileOutputStream.write(buffer,0,len);//减少内存与磁盘的IO次数，提升性能
        }

//        System.in.read();//阻塞当前线程，示范不关闭流的后果--多个用户同时操作当前文件会导致字节混乱
        fileOutputStream.close();
        fileInputStream.close();*/


        //版本2--自动关闭流->jdk7语法
        try( FileInputStream fis = new FileInputStream(file);
             //将内存数据写入到磁盘中
             FileOutputStream fos = new FileOutputStream("D:/timg_cp.png")){
            int len=0;
            byte[] buffer = new byte[1024];//控制每次写入到磁盘的字节大小
            while ((len=fis.read(buffer))!=-1){
//            fileOutputStream.write(len);
                fos.write(buffer,0,len);//减少内存与磁盘的IO次数，提升性能
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.in.read();//阻塞当前线程无影响

    }
}
