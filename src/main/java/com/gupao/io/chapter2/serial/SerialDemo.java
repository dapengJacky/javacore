package com.gupao.io.chapter2.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class SerialDemo {

    public static void main(String[] args) {
        //序列化--将内存中的对象状态信息转化为字节序列输出到磁盘
        /*try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:/user"))){
            User user= new User("Jacky",18);
            outputStream.writeObject(user);
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //反序列化--将磁盘中的字节数组转化为对象
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/user"))){
            User us = (User) objectInputStream.readObject();
            System.out.println(us);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
