package io;

import java.awt.image.BufferedImage;
import java.io.*;

/*
使用缓冲流完成文件复制
缓冲流：java.io.BufferedInputStream和BufferedOutputStream
他们是一对高级流 在流连接中的作用是提高读写效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis =
                new FileInputStream("spring.zip");
        BufferedInputStream bis =
                new BufferedInputStream(fis);

        FileOutputStream fos =
                new FileOutputStream("spring_cp.zip");
        BufferedOutputStream bos =
                new BufferedOutputStream(fos);
        int d = -1;
        long start = System.currentTimeMillis();

        while((d=bis.read())!=-1){
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        //关闭外层的流 里面的会自动随着外面的关闭而关闭
        System.out.println("复制完毕！"+(end-start)+"ms");
        bis.close();
        bos.close();
    }
}
