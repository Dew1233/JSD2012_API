package raf;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 简易记事本工具
 * 程序启动后要求用户输入一个文件名，然后对该文件进行写操作
 * 之后用户在控制台输入的每一行字符串都写入到该文件中
 * 当用户单独输入exit时候退出
 */
public class Note {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        //1输入文件名直至该文件名不存在
        System.out.println("输入文件名：");
        String filename = scan.nextLine();
        File file = new File(filename);
        while(file.exists()){
            if(file.exists()){
                System.out.println("该文件已经存在请再次输入文件名：");
                filename = scan.nextLine();
                file = new File(filename);
            }
        }
        //创建文件
        RandomAccessFile raf = new RandomAccessFile(filename+".txt","rw");
        //2控制台输入的每一行字符串都写入到该文件中
        System.out.println("输入文本,单独输入exit回车");
        String songtext = scan.nextLine();
        //防止方法返回的是null
        while (!("exit".equals(songtext))){
            byte [] data = songtext.getBytes("UTF-8");
            data = songtext.getBytes("utf-8");
            raf.write(data);
            songtext = scan.nextLine();
        }
        System.out.println("输出完毕");
        raf.close();
    }
}
