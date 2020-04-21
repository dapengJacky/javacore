package com.gupao.io.chapter2;

import java.io.*;
import java.net.Socket;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class IODataSourceDemo {


    public static void main(String[] args) throws IOException {
        //1.磁盘IO
   /*     try {
            FileInputStream fis = new FileInputStream("D:/test.txt");
            int i=0;
            while ((i=fis.read())!=-1){
                System.out.print((char)i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //2.内存IO
      /*  String str = "hello";
        ByteArrayInputStream bai = new ByteArrayInputStream(str.getBytes());
        int len=0;
        while ((len=bai.read())!=-1){
            System.out.print((char)len);
        }*/

        //3.键盘 Scanner
      /*  InputStream inputStream = System.in;
        int i=0;
        while ((i=inputStream.read())!=-1){
            System.out.print((char)i);
        }*/

        //4.网络IO
    /*    Socket socket = new Socket();
        socket.getInputStream();
        socket.getOutputStream();*/

    }

}
