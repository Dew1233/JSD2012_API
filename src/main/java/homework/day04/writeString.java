package homework.day04;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class writeString {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
//        1:首先获取用户输入的用户名和新的昵称
        System.out.println("请输入用户名：");
        String username = scan.nextLine();


        System.out.println("请输入密码：");
        String password = scan.nextLine();
        System.out.println("请输入昵称：");
        String nickname = scan.nextLine();

//        将用户名和昵称写进去
        RandomAccessFile raf = new RandomAccessFile("user.dat","rw");
        raf.seek(raf.length());
        byte[] data = username.getBytes("utf-8");
        data = Arrays.copyOf(data,32);
        raf.write(data);
        data = nickname.getBytes("UTF-8");
        data = Arrays.copyOf(data,32);
        raf.write(data);
        data = password.getBytes("utf-8");
        data = Arrays.copyOf(data,32);
        raf.write(data);
    }
}
