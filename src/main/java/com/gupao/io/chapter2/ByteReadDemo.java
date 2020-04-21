package com.gupao.io.chapter2;


import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class ByteReadDemo {

    public static void main(String[] args) {
        FileInputStream fileInputStream=null;
        try {
            fileInputStream = new FileInputStream("D:/test.txt");
            int len=0;
            byte[] bytes = new byte[1024];
//            byte[] bytes = new byte[3];乱码
            while ((len=fileInputStream.read(bytes))!=-1){
                System.out.print(new String(bytes,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
