package string;

/**
 * char charAt(int index)
 * 获取指定位置上的字符
 */
public class charAt {
    public static void main(String[] args) {
        String str= "thinking in java";

        //获取第5个字符(下标为4）
        char c = str.charAt(4);
        System.out.println(c);
    }
}
