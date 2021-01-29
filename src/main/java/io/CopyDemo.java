package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /*
        1创建文件输入流读取原文件爱你
        2创建文件输出流写入复制文件爱你
        3循环块读写完成复制
        4关闭两个流
         */
        FileInputStream fis =
                new FileInputStream("fos.txt");
        FileOutputStream fos =
                new FileOutputStream("fos_cp.txt");
        int len;
        byte[] data = new byte[1024*10];
        while ((len=fis.read(data))!=-1){//不传参数文件为空
            fos.write(data,0,len);
        }
        System.out.println("复制完毕！");
        fis.close();
        fos.close();
    }
}
