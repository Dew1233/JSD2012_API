package string;

/**
 * String一尺正则表达式的方法之三
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为给定内容
 */
public class replaceAllDemo {
    public static void main(String[] args) {
        String str = "abc123def456ghi789jkl";
        /**
         * 将字符串中的数字部分替换为#NUMBER#
         * 换了之后是有返回值的
         */
        //str = str.replaceAll("[0-9]+","#NUMBER#");

      //  str = str.replaceAll("[a-zA-Z]+","#NUMBER#");
       // System.out.println(str);
        //将满足的部分替换为空字符串可达到“去除"的效果
       // str = str.replaceAll("[a-zA-Z]+","");
        //System.out.println(str);
        //和谐用语
        String regex = "(wq|nc|dsb|fk)";
        String  message = "fk!你个nc!你就是一个dsb";
        message = message.replaceAll(regex,"***");
        System.out.println(message);
    }
}
