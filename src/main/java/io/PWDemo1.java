package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 缓冲字符输出流
 * java.io.BufferedWriter
 * 内部有缓冲区，可以快些文本数据来加快写出数据速度
 *
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流，内部总是连接BufferedWriter作为
 * 其缓冲功能
 */
public class PWDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        //向pw.txt文件中写入字符串
        /*
        PW提供对文件做操作的构造方法
        PrintWriter(String path)
        PrintWriter(File file)
--
         */
        PrintWriter pw = new PrintWriter("pw.txt");
        pw.println("让我掉下眼泪的");
        pw.println("让我依依不舍的");
        System.out.println("写出完毕");
        pw.close();
    }

}
