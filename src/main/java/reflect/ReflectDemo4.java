package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person p = new Person();
        p.sayHello();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();
        System.out.println("请输入方法名：");
        String methodName = scanner.nextLine();
        //反射
        Class cls = Class.forName(className);
        //实例化
        Object o = cls.newInstance();  //new Person()
        Method m = cls.getMethod(methodName);
        m.invoke(o);//p.sayHello  传入所属对象

    }
}
