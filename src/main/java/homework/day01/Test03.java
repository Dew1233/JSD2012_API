package homework.day01;
/**
 * 修改下面代码的错误
 *
 * 下面代码完成的功能是输出字符串中的每一个字符
 *
 */
 public class Test03 {
		//string str = "hello world! i love java!";
        String str = "hello world! i love java!";
//		for(int i = 0;i<=str.length;i++) {}

//			char c = i.charAt(i);
//			System.err.println(c);
//改正
    public static void main(String[] args) {
        String str = "hello world! i love java!";
        for(int i =0;i<str.length();i++){
            char c = str.charAt(i);
            System.err.println(c);
        }

    }
}
