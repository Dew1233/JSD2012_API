package homework.day01;

import java.util.Random;
import java.util.Scanner;

/**
 * 生成一个4位验证码(数字和字母的组合)
 * 然后输出到控制台并提示用户输入该验证码，只要用户输入正确(无论大小写都算)，
 * 就输出:验证码正确，否则输出:验证码错误
 *
 *
 * 验证码如何生成?
 * 思路导向填空:
 * 1:要先确定生成的内容范围(列出所有可以出现的字符):
 *
 * 2:先思考如何生成其中的一个字符呢？
 *   2.1:确定怎么保存这些可以出现的字符:
 *
 *   2.2:怎么能随机抽选一个
 *
 * 3:既然可以生成一个，如何做到生成4个或更多个?
 *
 * 4:怎么在生成这些字符的过程中将他们组成一个字符串?
 *
 * 5:获取到用户输入的字符串后怎么与之比较,要利用到哪些字符串操作?
 *
 *
 *
 */
public class Test06 {
    public static final int charint = 4;
    public static void main(String[] args) {
        /**
         *
         */

        String str = "0123456789abcdefghijklmnopqrstuvwxyz";
        char [] str1 = new char[charint];
        //定义一个长度为2的数组 随机生成字符存进去
        for(int i = 0;i<4;i++){
            Random rand = new Random();
            int k = rand.nextInt(str.length());
            str1[i] = str.charAt(k);

            System.out.println(str1[i]);
        }
        //把随机的数组转换成字符串
        String str2 = String.valueOf(str1);
        System.out.println(str2);
        //输入验证码
        Scanner scan = new Scanner(System.in);
        System.out.println("输入验证码");
        String input = scan.next();
        //验证
        String fact = input.toLowerCase();
        if(fact.equals(str2)){
            System.out.println("通过");
        }else {
            System.out.println("不通过");
        }
    }
}
