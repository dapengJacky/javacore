package com.gupao.io.chapter2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jacky
 * @description
 * @date 2020/4/21
 */
public class FlushDemo {

    public static void main(String[] args) throws IOException {

        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream("D:/tes.txt"));
        bufferedOutputStream.write("hello world".getBytes());
        bufferedOutputStream.flush();//刷盘--将缓冲区的数据写入到磁盘
    }
}
