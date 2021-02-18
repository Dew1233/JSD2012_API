package Map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map查找表
 * Map在java中是非常常用的一种数据结构，它的样子像是一个多行两列的表格。其中
 * 左列称为key 右列称为value
 * Map总是根据key获取对应的value
 *
 * 常用实现类:java.util.hashMap 散列表。当家查询速度最快的数据结构
 * 使用散列算法实现
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        /*
        V put(K k,V v)
        将一组键值对存入到当前Map中
        由于Map有一个要求：key不允许重复(使用key自身equals比较判定重复，与集合一致
        因此如果使用已有的key存放value时则会替换value。返回值为被替换的value
        如果key不存在，则正常存入Map 此时返回值为null

         */
        /*
        当Map的Value类型是包装类时候，获取该值应当使用包装类类型的变量接收
        不要使用对应的基本类型变量接收，避免自动拆箱导致的空指针异常
         */
        Integer value = map.put("语文",99);
        System.out.println("value："+value);
        map.put("数学",94);
        map.put("英语",94);
        map.put("政治",39);
        map.put("物理",95);
        map.put("历史",39);
        map.put("化学",97);
        System.out.println(map);

        value = map.put("语文",76);
        System.out.println(map);

    }
}
