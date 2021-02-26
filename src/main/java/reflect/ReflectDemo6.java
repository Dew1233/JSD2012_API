package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo6 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Person p = new Person();
//        p.hehe;编译不通过
        Class cls = Class.forName("reflect.Person");
        Object o = cls.newInstance();
        Method m = cls.getDeclaredMethod("hehe");
        m.setAccessible(true);//强制要求访问
        m.invoke(o);
    }
}
