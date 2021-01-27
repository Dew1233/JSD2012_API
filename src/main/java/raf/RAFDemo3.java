package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
使用RAF读写基本类型数据，以及RAF指针的操作
 */
public class RAFDemo3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf =
                new RandomAccessFile("raf1.txt","rw");

//        获取RAF的指针位置，默认从0开始
        long pos = raf.getFilePointer();
        System.out.println("pos:"+pos);
//        向文件里面输入最大值 因为每次读取都是读取低8位
        /*
        int 最大值的二进制           vvvvvvvv
        01111111 11111111 11111111 11111111
        imax>>>24
        00000000 00000000 00000000 01111111
        imax>>>16
        00000000 00000000 01111111 11111111
        imax>>>8
        00000000 01111111 11111111 11111111
        imax
        00000000 01111111 11111111 11111111
         */
        int imax = Integer.MAX_VALUE;
        System.out.println(imax);
        raf.write(imax>>>24);
        System.out.println("pos:"+raf.getFilePointer());//1
        raf.write(imax>>>16);
        raf.write(imax>>>6);
        raf.write(imax);
        System.out.println("pos:"+raf.getFilePointer());//4
        /*
        RAF提供了方便写出基本类型数据的方法
         */
        raf.writeInt(imax);
        raf.writeLong(123L);
        raf.writeDouble(123.123);
        System.out.println("写出完毕");

        raf.seek(0);
        System.out.println("pos"+raf.getFilePointer());//0
        int d = raf.readInt();
        System.out.println(d);//int最大值
        System.out.println("pos:"+raf.getFilePointer());//4


        //读取long值
        raf.seek(8);
        long l = raf.readLong();
        System.out.println(l);
        System.out.println("pos"+raf.getFilePointer());//16

        //读取double值
        double dou = raf.readDouble();
        System.out.println(dou);
        System.out.println("pos:"+raf.getFilePointer());//24

//       修改raf.dat文件中long所在位置的值改为456
//        1将指针移动到long值的开始位置
        raf.seek(8);
//        2重新写入新的long值来覆盖原本的数据
        raf.writeLong(456L);

        raf.seek(8);
        l=raf.readLong();
        System.out.println(l);
        raf.close();


    }

}
