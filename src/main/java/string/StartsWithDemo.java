package string;

/**
 * boolean startsWith(String str)
 * 判断字符串是否以给定的字符串开始的
 *
 * boolean endsWith(String str)
 * 判断字符串是否以给定的字符串结束的
 */
public class StartsWithDemo {
    public static void main(String[] args) {
        String str = "www.redu.cn";

        boolean starts = str.startsWith("www");
        System.out.println("starts:"+starts);
    }
}
