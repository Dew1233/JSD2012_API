package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo5 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Person p = new Person();
        p.say("大家好");
        p.say("大家好啊",5);

        Class cls = Class.forName("reflect.Person");
        Object o = cls.newInstance();
        Method m = cls.getMethod("say",String.class);
        m.invoke(o,"大家好~~~");
        Method m2 = cls.getMethod("say",String.class,int.class);
        m2.invoke(o,"大家好啊！",5);
     }
}
