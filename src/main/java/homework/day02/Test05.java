package homework.day02;

import java.util.Scanner;

/**
 * 程序需求:
 * 程序启动后，实例化一个Person，然后要求用户输入用户名
 * 和年龄.并加以验证:
 * 名字至少一个字符，否则输出:姓名不能为空!
 * 年龄必须是0-100之间的数字，否则输出:年龄不合法!
 *
 * 都输入正确时最后输出该用户信息
 *
 * 将下面写好的代码解除注释改正里面的错误使得程序可以正常
 * 运行。
 * 异常记一记:
 * 下面会出现的每一种异常先翻译异常的名字，然后解决该异常后
 * 思考是什么原因引起的错误并在注释中标注出来
 *
 * @author Xiloer
 *
 */
public class Test05 {


    public static void main(String[] args) {
		Person p = new Person();
		//123没有引入Scanner
//		Scanner scanner = new Scnner(system.in);
        Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名:");
		String name = scanner.nextLine();
		/*
		空指针异常原因：
		当我们调用某个对象的属性或者方法时候，如果此对象是null
		就会引发空指针异常
		分析：p.getName().length()
		p.getName是null
		逻辑错误 应该判断用户输入的name是否为null
		 */
		//Exception in thread "main" java.lang.NullPointerException
        //	at day02.Test05.main(Test05.java:33)
//		if(p.getName().length()==0) {
        //1利用了字符匹配来看是否为空,匹配输入的东西


        if(name.length()==0) {
			System.out.println("姓名不能为空!");
		}else{
			p.setName(name);
            System.out.println("请输入年龄:");
            int age = scanner.nextInt();
//            if(p.getAge()<0&&p.getAge()>100) {
            if(age<0||age>100) {
                System.out.println("年龄不合法!");
            }else{
                p.setAge(age);
            }
            System.out.println("姓名:"+p.getName());
            System.out.println("年龄:"+p.getAge());
		}
		/*System.out.println("请输入年龄:");
		int age = scanner.nextInt();
		if(p.getAge()<0&&p.getAge()>100) {
			System.out.println("年龄不合法!");
		}else{
//			p.age = age;
           p.setAge(age);
		}*/

		/*System.out.println("姓名:"+p.name);
		System.out.println("年龄:"+p.age);*/

    }


}

class Person{
    private String name;
    private int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}