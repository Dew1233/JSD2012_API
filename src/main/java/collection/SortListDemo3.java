package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("苍老师");
        list.add("传奇");
        list.add("小泽老师");

        System.out.println(list);
//        按字符多少排序
        Collections.sort(list,(s1,s2)->s1.length()-s2.length());
        System.out.println(list);
        Collections.sort(list,(s1,s2)->s2.length()-s1.length());
        System.out.println(list);
    }
}
