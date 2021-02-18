package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ForeachDemo {
    public static void main(String[] args) {
        List<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);

        //新循环
        for (String str:c){
            System.out.println(str);
        }
        /*
        foreach
        Collection的foreach方法要求传入一个lambad表达式，然后将集合每个元素
        都顺序的传给lambda中的str,并执行一次表达式

        与迭代器相比 由于迭代器是用另一个类Iterator来遍历集合，因此它遍历的过程
        不允许用集合的方法增删元素(结合有并发安全的实现类，但是仍然不允许多线程操作
        时使用迭代器遍历与集合方法增删同时进行)否则会抛出异常

        但是集合新添加的foureach方法在遍历的过程中没有上述的限制
        因为foreach是集合自身方法，因此对于并发安全的集合实现类，增删元素
        和foreach有很好的互斥性，可以保证多线程的并发安全

        我们常见的集合实现类：ArrayList LinknedList HashSet都不是并发安全的
        因此多线程情况下不应当操作的
        集合的工具类：java.until.Collections提供了一组静态方法，可以将实现的集合
        转换为一个并发安全的集合
         */
        //将当前集合转换为一个线程安全的集合
        c= Collections.synchronizedList(c);

        /* c.forEach(
                (str)->{
                    System.out.println(str);
                }
        );*/
        c.forEach((str)-> System.out.println(str));
    }
}
