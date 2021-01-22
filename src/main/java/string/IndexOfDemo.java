package string;

/**
 * int indexOf(String str)
 * 返回给定字符串在当前字符串的位置 如果当前字符串不包含给定内容则返回值为-1
 */

public class IndexOfDemo {
    public static void main(String[] args) {

        String str = "thinking in java";
        int index  = str.indexOf("in");//检索str第一次出现in的位置
        System.out.println(index);

        index = str.indexOf("in",3);//从下标3开始找起来出现in的位置
        System.out.println(index);

        index = str.lastIndexOf("in");//检索str最后一次出现in的位置
        System.out.println(index);
        //如果想判断一个邮箱里面只能出现一个@ 判断第一次和最后一次出现的地址值是否匹配就可以
        //str.indexof==str.lastof

    }
}
