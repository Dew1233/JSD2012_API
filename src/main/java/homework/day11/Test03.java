package homework.day11;

import java.util.*;

/**
 * 生成10个0-100之间的不重复的随机数,并输出
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Random rand = new Random();
		int input = rand.nextInt(100);
		//1判断生成的数字是否重复
//		2生成十个
		List<Integer> list = new ArrayList<>();

			for (int i = 0; i < 10; i++) {
			input = rand.nextInt(100);
//			判断循环
			boolean contains = list.contains(input);
			if (contains){
				System.out.println(input);
				list.remove(input);
				i--;
			}
			list.add(input);
		}
		System.out.println(list);
	}
}
