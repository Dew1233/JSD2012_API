package thread;

import java.util.Scanner;

/*

 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        /*
        完成一个倒计时程序要求用户输入一个数字。
        然后从该数字开始每秒递减，到0时提示时间到
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("输入一个数字：");
        int num = scan.nextInt();
        System.out.println("倒计时开始");
        try {
            for (int i= num;i>0;i--){
                Thread.sleep(1000);
                System.out.println(i);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("时间结束了");
    }
}
