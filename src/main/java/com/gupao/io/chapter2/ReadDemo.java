package com.gupao.io.chapter2;

import java.io.FileInputStream;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class ReadDemo {


    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("D:/test.txt")){
            int len=0;
            byte[] buffer = new byte[3];
//            byte[] buffer = new byte[11];
            //buffer值--通过覆盖当前buffer数组中的值来写入
            //[][][]->[H][e][l] -> [l][o][ ] -> [W][o][r] -> [l][d][r]
            while ((len=fileInputStream.read(buffer))!=-1){
//                System.out.println(new String(buffer));
                System.out.println(new String(buffer,0,len));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
