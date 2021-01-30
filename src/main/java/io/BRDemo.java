package io;

import java.io.*;

/*
缓冲字符输入流
java.io.BufferedReader
内部维护一个缓冲区可以块读文本数据，并且可以按行读取字符串
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
//        将当前源代码读取出来并输出到控制台
//        文件流
        FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.java");
//        转换流
        InputStreamReader ios = new InputStreamReader(fis);
//        缓冲流
        BufferedReader br = new BufferedReader(ios);
        /**
         * BufferedReader提供的方法：
         * String readLine()
         * 读取一行字符串，读取到换行符停止，将换行符之前的内容
         * 以一个字符串形式返回(不含有最后的换行符）
         * 如果此行为空行，即：只有换行符，则返回值为空字符串
         * 如果此方法返回值为null 说明流读取到了末尾
         */
        String line;
        while ((line = br.readLine())!=null){

        System.out.println(line);
        }

        br.close();
    }

}
