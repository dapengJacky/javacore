package com.gupao.io.chapter2;


import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class ReaderWriterDemo {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("D:/test.txt");
                FileWriter fileWriter = new FileWriter("D:/tes.txt")){
            int len=0;
            char[] cs = new char[1024];
            while ((len=fileReader.read(cs))!=-1){
                System.out.println(new String(cs,0,len));
                fileWriter.write(cs,0,len);
            }
          /*  BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());//读取一行*/

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
