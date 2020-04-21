package com.gupao.io.chapter2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author jacky
 * @description 内存字节流
 * @date 2020/4/21
 */
public class MemoryDemo {

    public static void main(String[] args) {
        String str="hello world";
        //从内存中读取数据
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = 0;
        while ((i=bais.read())!=-1){
            char c =(char)i;
            //写出到内存中
            baos.write(Character.toUpperCase(c));
        }

        System.out.println(baos.toString());
    }
}
