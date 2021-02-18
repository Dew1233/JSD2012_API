package Map;

import java.util.*;

public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("语文",65);
        map.put("数学",94);
        map.put("英语",94);
        map.put("政治",39);
        map.put("物理",95);
        map.put("历史",39);
        map.put("化学",97);
        /*
        遍历所有的key
        Set<K> keySet(）
        将当前Map中所有的key以一个Set集合形式返回,遍历这个集合
        等同于遍历所有key
         */
        Set<String> keySet = map.keySet();
        for (String key :keySet){
            System.out.println("key:"+key);
        }

        /*
        遍历每一组键值对
        Set<Entry> entrySet()
        将当前Map中每一组键值对(一个Entry实例表示一组键值对）
        都存入到一个Set集合中

        java.util.Map.Entr它的每个实例表示一组键值对
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for (Map.Entry<String,Integer> e : entrySet){
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);
        }

        /*
        Collection<V> values()
        将当前Map所有的value以一个Collection形式返回
         */
        Collection<Integer> values = map.values();
        for (Integer value :values){
            System.out.println("value:"+value);
        }
    }
}
