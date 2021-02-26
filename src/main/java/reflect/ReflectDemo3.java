package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用有参构造器实例化对象
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person p = new Person("刘苍松",33);
        System.out.println(p);

        //反射
        Class cls = Class.forName("reflect.Person");

        Constructor c = cls.getConstructor();//不传参数就是获取无参构造器器

        Constructor d = cls.getConstructor(String.class,int.class);

        Object o = d.newInstance("范传奇",22);
        System.out.println(o);
    }
}
