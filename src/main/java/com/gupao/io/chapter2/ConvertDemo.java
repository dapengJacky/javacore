package com.gupao.io.chapter2;


import java.io.*;

/**
 * @author jacky
 * @description 字节流转化为字符流
 * @date 2020/4/21
 */
public class ConvertDemo {


    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("D:/test.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("D:/tes.txt")){
            //字节流转换为字符流
            InputStreamReader reader = new InputStreamReader(fileInputStream,"utf-8");
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream,"gbk");
         /*   BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader.readLine());*/
            int len=0;
            char[] crs = new char[1024];
            while ((len=reader.read(crs))!=-1){
//                System.out.print((char)len);
                System.out.print(new String(crs,0,len));
//                writer.write(crs,0,len);
                writer.write("你好");//如果charset为gbk,输出为ASCII编码
                writer.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
