package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * java反射机制
 * java的反射机制是一个动态机制，允许我们在程序运行期间再确定实例化，调用方法，
 * 操作属性等，这样可以提高代码的灵活度
 * 但是反射带来的更多的系统开销和较慢的运行效率
 * 所以不能过度的依赖反射机制
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        Class类，称为类对象。java中每个被JVM加载的类有且只有唯一一个Class实例与之对应
        通过获取一个类的类对象就可以通过这个类对象了解这个类的一切信息(类名，构造器，方法，属性)
        并在程序运行期间去操作它们

        反射第一步就是获取要操作的类的类对象
        获取方式有三种:
        1:类名.class,例如
        Class cls = String.class;//获取字符串的类对象
        Class cls = int.class;//获取int的类对象(注：基本类型只能通过这种方式获取类对象)

         2：Class.forName(String clasName),例如：
         Class cls = Class.forName("java.lang.String");//参数为加载的类的完全限定名(包名.类名 )

         3：使用类加载器ClassLoader


         */

        //获取String的类对象
//        Class cls = String.class;


        /*
        通过指定要加载的类完全限定名获取类对象，如果指定的名字不对，则会抛出异常：
        ClassNotFoundException
         */
//        Class cls = Class.forName("java.lang.String");//包名.类名

        /*
        java.io.RandomAccessFile
        java.io.FilrInputStream
        java.util.HashMap
        java.util.ArrayList
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);



//        Class cls = Class.forName("reflect.Person");

        String name = cls.getName();
        System.out.println("类名："+name);  //java.lang.String 完全限定名
        name = cls.getSimpleName();
        System.out.println("类名："+name);




        //获取当前类的所有public方法，包含从超类继承的方法
        Method[] methods = cls.getMethods();
        for (Method m:methods){
            String methodName = m.getName();
            System.out.println(methodName);
        }
    }
}
