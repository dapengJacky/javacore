package com.gupao.io.chapter2;

import java.io.*;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class FileDemo {


    public static void main(String[] args) throws IOException {
        //通过输入一个本地磁盘路径遍历该路径下的所有文件
        InputStream inputStream = System.in;
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader bis = new BufferedReader(isr);
        try {
            String line = bis.readLine();
            File file = new File(line);
            if(file.isDirectory() && file.exists()){
                fileList(file);
            }else {
                System.out.println("输入的文件路径不存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bis.close();
            isr.close();
        }
    }

    private static void fileList(File file){
        File[] files = file.listFiles();
        if(files!=null){
            for (int i = 0; i <files.length ; i++) {
                if(files[i].isFile()){
                    System.out.println(files[i].getName());
                }else{
                    //递归遍历目录
                    fileList(files[i]);
                }

            }
        }
    }
}
