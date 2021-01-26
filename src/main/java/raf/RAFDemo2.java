package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RAFDemo2 {
    public static void main(String[] args) throws IOException {
     RandomAccessFile raf = new RandomAccessFile(
             "raf.dat","rw"
     );
     /*
     int read()
     从文件中读取一个字节 并以int型返回。实际读取的字节是在
     返回的int值对应的2进制的低8位上
     但如果返回值为-1则表示文件末尾 EOF:enf of file
      */
//00000000 00000000 00000000 00000001
     int d = raf.read();//1
        System.out.println(d);
        //00000000 00000000 00000000 00000010
        d = raf.read();//2
        System.out.println(d);
        //00000000 00000000 00000000 00000011
        d = raf.read();//3
        System.out.println(d);
//11111111 11111111 11111111 11111111
        d = raf.read();//-1 文件末尾
        System.out.println(d);
        raf.close();
    }
}
