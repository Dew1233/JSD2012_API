package io;

import java.io.*;
import java.util.Scanner;

/*
简易记事本
输入文件名，对文件进行写操作
输入的字符按行写入到文件中
单独输入exit时退出
创建PrintWriter创建流连接完成
 */
public class Note {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入文件名：");
        String  fosname = scan.nextLine();
//下一次写入数据的时候会追加到当前的文件中
//        文件流 低级流 将字节写入文件
       FileOutputStream fos =
               new FileOutputStream(fosname+".txt",true);
//      高级流 osw转换流  衔接其他字符流和字节流  将字符转换为字节
       OutputStreamWriter osw =
             new OutputStreamWriter(fos,"utf-8");
//      高级流 缓冲字符流  块写文本数据加速
       BufferedWriter bw = new BufferedWriter(osw);
//      高级流  按行写出字符串 可以自动行刷新 输出换行的时候就会自动刷新
        /**
         * 当创建PW时候第一个参数为流，则可以再传入一个boolean型参数
         * 如果这个值为true,则当前pw具有自动行刷新功能。即：
         * 每当我们调用println方法后会自动flush
         */
        PrintWriter pw = new PrintWriter(bw,true);
        System.out.println("请开始输入内容，单独输入exit退出。");
        while (true){
            String line = scan.nextLine();
            if("exit".equals(line)){
                break;
            }
            pw.println(line);

        }
        pw.close();


    }
}
