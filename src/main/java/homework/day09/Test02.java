package homework.day09;
/**
 * 修改下面代码的编译
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run(){
				Foo.dosome();
			}
		};
		Thread t2 = new Thread() {
			public void run(){
				Foo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

/**
 * 静态方法上使用synchronized时候，该方法一定具有同步效果
 * 静态方法上使用的同步监视器对象为当前类的类对象，即：class的实例
 * java中每个被JVM加载的类都有且只有唯一一个类对象与之对应，因此静态方法锁
 * 该对象一定具有同步效果
 * 获取一个类的类对象可以使用类名.class方法得到
 */
class Foo{
	public static void dosome() {
		synchronized (Foo.class) {
			System.out.println("hello!");
		}
	}
}

