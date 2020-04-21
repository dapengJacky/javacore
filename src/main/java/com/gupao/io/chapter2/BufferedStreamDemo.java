package com.gupao.io.chapter2;

import java.io.*;

/**
 * @author jacky
 * @description 缓冲流与文件流的区别
 * 读取文件时先读取到缓冲区;写出文件时也先写入到缓冲区；默认8kb
 * @date 2020/4/21
 */
public class BufferedStreamDemo {

    private static File fileSource = new File("D:/Software/CentOS-7-x86_64-DVD-1908.iso");
    private static File fileTarget = new File("D:/CentOS-7-x86_64-DVD-1908.iso");
    /**
     * FileInputStream流拷贝文件
     */
    public static void copyWithNormal(){
        try(FileInputStream fileInputStream = new FileInputStream(fileSource);
            FileOutputStream fileOutputStream = new FileOutputStream(fileTarget)){
            int len=0;
            byte[] bys= new byte[8192];
            while ((len=fileInputStream.read(bys))!=-1){
                fileOutputStream.write(bys,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * BufferedInputStream流拷贝文件
     */
    public static void copyWithBuffer(){
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileSource));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileTarget));
            int len=0;
            byte[] bys= new byte[1024];
            while ((len=bufferedInputStream.read(bys))!=-1){
                bufferedOutputStream.write(bys,0,len);
                bufferedOutputStream.flush();//没有此行代码，最后一次缓冲区的数据(小于8K)不会写入到磁盘，最终文件大小会变小
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        copyWithNormal();
        Long end = System.currentTimeMillis();
        System.out.println(end-start);//4.3G大小文件--9秒

        Long start1 = System.currentTimeMillis();
        copyWithBuffer();
        Long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);//4.3G大小文件--7秒

    }
}
