package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过提高每次读写的数据量减少实际读写的次数可以提高读写效率
 * 单字节读写是随机读写
 * 一组字节读写是块读写
 * 对于机械硬盘而言，单字节读写几乎没有效率可言，块读写效率很好
 * 对大部分硬件而言 减少硬件调用次数都可以提高效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {

        RandomAccessFile src =
                new RandomAccessFile("git.exe","r");
        RandomAccessFile desc =
                new RandomAccessFile("git_cp.exe","rw");
        /*
        RAF提供的块读写方法：
        块写：
        void write(byte[] data)
        void write(byte[] data,int offset,int len)
        一次性将给定数组中从下标offset处的连续
        块读：
        int read(byte[] data)
        一次性从文件读取给定的字节数组data总长度的字节量并将
        读取道德字节顺序的存入到该数组中。返回值为实际读取到的
        字节量。如果返回值为-1则表示读取到了文件末尾

         */


        int len;//记录每次块读数据后，实际读取到的字节数
        byte[] data = new byte[1024*10];//10kb
        long start = System.currentTimeMillis();
        while ((len = src.read(data))!=-1){
            desc.write(data,0,len);//读了多少字节就一次写多少自己诶
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间："+(end-start)+"ms");
        src.close();
        desc.close();
    }
}
