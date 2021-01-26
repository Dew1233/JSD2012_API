package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/*
java.io.RandomAccessFile
RAF是专门用来读写文件的类 其基于指针对文件进行随机读写
 */
public class RAFDemo1 {
    public static void main(String[] args) throws IOException {
        //相对当前目录下的raf.dat文件进行操作
        /*
        RAF常用构造器
        RandomAccessFile(File file,String mode)
        RandomAccessFile(String path,String mode)
        第一个参数为要进行读写的文件可以传入file对象也可以直接给定该文件的路径
        第二个参数为操作模式，有两种：
        “r”只读模式，仅对该文件做读取数据操作
        “rw"读写模式，对文件读写均可
         */
        RandomAccessFile raf = new RandomAccessFile(
          "./raf.dat","rw"
        );
       //向文件爱你中写入一个字节的二进制数据
        /*
        void write(int d)
        向文件中写入一个字节，写入的是给定的int值 所对应的2进制
        的”低八位“
        int型正数1的2进制：
        00000000 00000000 00000000 00000001

        write方法写入gaiint值对应2进制度的低八位：
                                   vvvvvvvv
        00000000 00000000 00000000 00000001
         */
        raf.write(1);
        raf.write(2);
        raf.write(-1);

        /*
        raf.dat文件数据内容：
        00000001 00000010
         */
        System.out.println("写入完毕");
        raf.close();//最终要调用close方法
    }
}
