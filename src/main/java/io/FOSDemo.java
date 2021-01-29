package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * java标准的io,可以用相同的读写方式读写不同的设备
 * java将IO比喻成流，可以理解为是为连接程序与设备之间的管道，管道
 * 里面是按照同一个方向顺序流动的字节
 *
 * java将流的方向划分为两个操作
 * 输入：用来读取，是从设备到程序的方向，是获取的数据使用的。
 * 输入：用来写出，是从程序到设备的方向，是发送的数据使用的。
 *
 * java将流氛围两类：节点流和处理流
 * 节点流：也成为低级流，是实际连接程序与设备的管道，负责实际读取字节的流
 *        读写一定是建立在节点流的基础上进行的。操作不同的设备有相应的
 *        低级流。例如读写文件有文件流。
 * 处理流：也称为高级流，不能独立存在，必须连接在其他流上，目的是当数据
 *        “流经”当前流时对其做某些加工处理简化我们的操作
 * 实际开发中我们总是会串联一组高级流最终连接到低级流上，在数据进行读写的
 * 过程中对数据做流水线式的加工处理，这也称为流连接，也是IO的精髓
 *
 * 文件流
 * 文件流是一对低级流，用于读写文件的流，功能上与RandomAccessFile一致
 * java.io.FileInputStream和FileOutputStream
 */

public class FOSDemo {
    public static void main(String[] args) throws IOException {
        /*
        文件输出流构造方法：
        FileOutputStream(String path)
        FileOutputStream(File file)
        以上两种构造器创建的文件流为覆盖写模式
        即：创建爱你文件流时如果指定的文件已经存在，则会将该文件内容清空
        然后使用这个流写出的数据会顺序写入文件爱你作为新数据保存
        注意：RAF是从头开始写多少覆盖多少（不操作指针的情况下）

        文件流重载的构造方法
        FileOutputStream(String path,boolean append)
         FileOutputStream(File file,boolean append)

         如果第二个参数指定并且指定的值为true时,则当前文件流为追加模式
         创建文件流时如果文件存在
         */
        FileOutputStream fos = new FileOutputStream("fos.txt");
        String line = "共筑中国梦";
        byte [] data = line.getBytes("utf-8");
        fos.write(data);
        line = "绿水青山就是金山银山";
        fos.write(line.getBytes("utf-8"));

        fos.write("第一句歌词".getBytes());
        fos.write("第二句歌词".getBytes());
        System.out.println("写出完毕");
        fos.close();

    }
}
