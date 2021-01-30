package homework.day04;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成修改昵称工作
 *
 * 程序启动后，要求用户输入用户名和新的昵称
 * 然后修改user.dat文件中该用户的昵称
 * 如果输入的用户不存在，则输出"查无此人"
 *
 * 思路:
 * 可以分几步实现:
 * 1:首先获取用户输入的用户名和新的昵称
 * 2:尝试循环读取user.dat文件中的每个用户名并打桩输出到控制台
 * 3:在读取用户名没有问题后，加上一个判断，判断该用户名是否为当前
 *   用户输入的用户名，匹配上则打桩输出
 * 4:如果匹配测试没问题，在分支中将指针移动到这条记录的昵称位置，
 *   需要思考昵称位置的计算。
 *   然后将昵称转换为字节后扩容到32字节写入覆盖即可。
 * @author Xiloer
 *
 */
public class Test02 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
//        1:首先获取用户输入的用户名和新的昵称
        System.out.println("请输入用户名：");
        String name = scan.nextLine();
        System.out.println("请输入新的昵称：");
        String nick = scan.nextLine();
        RandomAccessFile raf =
                new RandomAccessFile("user.dat","rw");

        boolean update = false;//是否有记录被修改过
//      2尝试循环读取user.dat文件中的每个用户名并打桩输出到控制台
        for(int i =0;i<raf.length()/100;i++) {

            //将指针移动到该条记录的开始位置
            raf.seek(i * 100);
            //读取该条记录的用户名
            byte[] data = new byte[32];
            raf.read(data);
            String username = new String(data, "utf-8").trim();
            //判断是否是该用户
            if (username.equals(name)) {
                //找到该用户
                //将指针移动到该条记录的昵称位置
                raf.seek(i*100+64);
                data = nick.getBytes("utf-8");
                data = Arrays.copyOf(data, 32);
                raf.write(data);
                update = true;//修改过记录 证明有该用户
                break;//修改过之后停止循环
            }
        }
        if(update){
            System.out.println("修改成功");
        }else {
            System.out.println("查无此人");
        }



        raf.close();
    }
}
