package homework.day02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式练习:
 * 1:编写匹配数字的正则表达式,数字至少一位以上.
 *[0-9]{1,}
 * 2:匹配字符串,要求输入3-15位,内容只能是数字,字母下,划线
 *
 *
 * 完成下面编程题:
 * 程序启动后,要求用户输入用户名,用户名出现内容要求上述正则表达式2的要求.不匹配则直接
 * 提示用户名有误.
 * 如果无误,则要求用户继续输入年龄,规则为上述正则表达式1的要求,不匹配则提示年龄有误
 * 以上两个输入获取是都要求以字符串形式接受(Scanner的nextLine方法获取)
 *
 * 最后验证年龄在1-100岁之间(包含1和100)
 * 提示:这里可以不用正则表达式验证范围,是否转换为数字判定更方便?
 * @author Xiloer
 *
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("姓名：");
        String name = scan.nextLine();
        Pattern pattern = Pattern.compile("[0-9A-Za-z_]{3,15}");
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches()){
            System.out.println("年龄：");
            String age = scan.nextLine();
            Pattern pattern1 = Pattern.compile("[0-9]+");
            Matcher matcher1 = pattern1.matcher(age);
            int age1 = Integer.parseInt(age);
            if(matcher1.matches()&&age1<100&&age1>=1){
                System.out.println("登录成功");

            }else {
                System.out.println("年龄有误");
            }
        }else{
            System.out.println("用户名有误");
        }

    }
}
