package com.gupao.io.chapter1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("D:/test.txt");
            int len=0;
            while ((len=fis.read())!=-1){
                System.out.print((char)len);//ASCII转码--数字对应字母
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
