package io;

import java.io.*;

/*
字符流 java.io.Reader 和 java.io.writer
java将流按照读写单位划分为字节流和字符流
字节流的超类是：java.io.InputStream和OutputStream
而字符流的超类是：java.io.Reader和java.io.Writer
他们的区别是读写单位不同，字节流最小读写单位为一个字节，而字符流的
最小读写单位为一个char(一个字符)
转换流：java.io.InputStreamReader和java.io.OutputStreamWriter
转换流是常用的字符流实现类，它们是一对高级流，实际开发中我们不会直接使用他
但是它们在流连接中是非常重要的一环

因为其他高级字符流都有一个共同特点，在流连接中只能连接其他字符流
而真是读写设备的低级流通常都是字节流，这会导致这些高级字符流不能直接
连接字节流。而转换流就在其中起到转换器的作用，它可以连接字节流
而且他又是字符流，其他字符流可以连接它。而它就负责将字符转换为字节流
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
//        向osw.txt文件中写入字符串
        FileOutputStream fos = new FileOutputStream("osw.txt");
        OutputStreamWriter osw =
                new OutputStreamWriter(fos);

        osw.write("夜空中最亮的星星，能否听清");
        osw.write("那仰望的人，心底的孤独和叹息");

        System.out.println("写出完毕！");
        osw.close();
    }
}
