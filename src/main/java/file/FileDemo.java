package file;

import java.io.File;

/**
 * java.io.File可以表示硬盘上的一个文件或者一个目录
 * 使用File可以：
 * 1:访问其表示文件或目录的属性(名字，大小等）
 * 2：操作文件或目录(创建，删除）
 * 3：访问一个目录的子项内容
 * 但是不能访问文件数据
 */

public class FileDemo {
    public static void main(String[] args) {
        /*
        File创建时候可以指定路径
        该路径通常使用相对路径，他有更好的跨平台性

        相对路径中“./"表示当前目录，当前目录具体是哪里要视
        当前程序的运行环境而定。在idea或者eclipse里运行时
        当前目录就是这个程序所在的项目目录
         */
        File file = new File("/demo.txt");
        //获取名字
        String name = file.getName();
        System.out.println(name);
        //获取长度（单位是字节）
        long len = file.length();
        System.out.println(len+"字节");

        boolean cr = file.canRead();
        System.out.println("可读："+cr);
        boolean cw = file.canWrite();
        System.out.println("可写："+cr);
    }
}
