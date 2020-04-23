package com.gupao.io.nio.disk;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author jacky
 * @description 零拷贝案例
 * @date 2020/4/23
 */
public class MMAPDemo {

    public static void main(String[] args) {

        try {
            FileChannel inChannel = FileChannel.open(Paths.get("D:/timg.png"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("D:/timg_cp.png"),StandardOpenOption.READ,StandardOpenOption.WRITE);

            MappedByteBuffer inMapBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
            MappedByteBuffer outMapBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

            byte[] bytes = new byte[inMapBuffer.limit()];
            inMapBuffer.get(bytes);
            outMapBuffer.put(bytes);
            outChannel.close();
            inChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
