package string;

/**
 * 字符串常量池是JVM在堆内存中专门为字符串提供的一段空间，用于缓存所有使用字面量形式
 * 创建的字符串对象，当再使用相同字面量创建字符串时候会直接重用常量池中的对象而不会再次
 * 创建新对象减少内存开销
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "123abc";
        System.out.println("s1"+s1);
        //s2字面量与s1相同 因此重用了上面s1创建的字符串
        String s2 = "123abc";
        System.out.println("s2:"+s2);
        System.out.println(s1==s2);//s1==s2为true 说明保存的地址一样 使用的同一个对象

        String s3 = new String("123abc");
        System.out.println("s3："+s3);
        System.out.println(s2==s3);

        //比较字符串内容要用equals
        System.out.println(s2.equals(s3));//true 比较的是字符串对象的内容是否相同

        /**
         * 编译器有一个特性：
         * 当编译器在编译一段代码的时候发现一个计算表达式在编译期间可以确定结果的时候就会进行计算，并且将
         * 结果编译到class文件中，这样虚拟机运行该程序时候就不用每次都进行计算
         * String s4 = "123abc";
         */
        String s4 = "123"+"abc";
        System.out.println("s4"+s4);
        System.out.println(s4==s2);

        String s = "123";
        String s5 = s+"abc";
        System.out.println("s5"+s5);
        System.out.println(s5==s2);
    }
}



























































































































































































































































































