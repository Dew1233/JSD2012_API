package io;

import java.io.*;

/*
使用流连接形式创建PW完成文本数据的写出操作
 */
public class PWDemo2 {
    public static void main(String[] args) throws IOException {
//        向pw2.txt中写入数据
//        低级流，用于字节写入文件
        FileOutputStream fos
                = new FileOutputStream("pw2.txt");
        OutputStreamWriter osw
                = new OutputStreamWriter(fos);
        //高级流，缓冲字符输出流。负责块写文本加速
        BufferedWriter bw = new BufferedWriter(osw);
        //高级流 PW 负责按行写字符串，并可以自动行刷新
        PrintWriter pw = new PrintWriter(bw);
        pw.println("和我在成都的街头走一走");
        pw.println("直到所有的灯都熄灭了，也不停留");

        pw.close();
    }
}
