package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 向文件中写入文本数据
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf =
                new RandomAccessFile("raf.txt","rw");

        /*
        常见的支持中文的字符集：
        GBK:国标编码，其中英文是1字节，所有中文2字节
        UTF-8:万国码，其中英文是1字节，中文3字节
         */
        //第一句歌词
        String str = "星星之火可以燎原";
        /*
        String 提供的方法：
        byte[] getBytes(String csn)
        将当前的字符串内容按照制定的字符集转换为一组字节
        该方法要求必须处理：UnsupportEncodingExpection异常
        当指定的字符集名字不对时会抛出该异常
         */
        byte [] data = str.getBytes("UTF-8");
        raf.write(data);

        //第二句歌词
        str = "团结一致，众志成城";
        data = str.getBytes("utf-8");
        raf.write(data);

        //第三句歌词
        str = "胜利终将属于中华儿女";
        data = str.getBytes("utf-8");
        raf.write(data);
        System.out.println("输出完毕");
        raf.close();


    }
}
