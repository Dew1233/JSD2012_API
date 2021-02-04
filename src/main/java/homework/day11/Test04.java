package homework.day11;

import java.util.*;

/**
 * 生成10个0-100的随机数并存入一个List集合中并输出
 * 之后将集合元素翻转:第一个在最后一个，最后一个在第一个。
 * 以此类推，并输出
 * 
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) {
        Random rand = new Random();
        int input = rand.nextInt(100);
        //1判断生成的数字是否重复
//		2生成十个
       List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            input = rand.nextInt(100);
//			判断循环
            list.add(input);
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

}
