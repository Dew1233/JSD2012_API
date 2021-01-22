package string;

/**
 * String toLowerCase()
 * 将当前字符串中的英文部分转换为全小写
 *
 * String toUpperCase()
 * 将当前字符串中的英文部分转换为全大写
 */
public class ToUpperCase {
    public static void main(String[] args) {
        String str = "hellWORLD";
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());

        String code = "ae3gh";
        String input ="AE3gh";
        String fact = input.toLowerCase();
        if(code.equals(fact)){
            System.out.println("通过");
        }else {
            System.out.println("不通过");
        }
    }
}
