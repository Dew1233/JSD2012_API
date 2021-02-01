package thread;


/**
 * 多线程
 * 多线程可以让多个代码片段并发执行，造成一种"同时"运行的现象。
 *
 * 线程有两种创建方式
 * 方式一:继承Thread并重写run方法
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        /*
        注意，启动线程的时候要调用线程的start方法，而不是直接调用run方法
        线程调用start方法中会纳入线程调度器中，线程调度器会分配CPU时间段
        给当前线程使得他可以和其他线程并发运行
        当该线程第一次获取时间片段时候会自动执行run方法
         */
        t1.start();
        t2.start();
    }
}

/**
 * 第一种创建线程的方式优点在于结构简单，利于匿名内部类形式创建
 * 缺点有两个：
 * 1由于java是单继承的，这会导致如果继承了Thread就无法继承其他类的复用方法，
 * 实际开发中是非常不方便
 * 2定义线程的同时重写了run方法，这导致将任务直接定义在了线程中使得线程与任务
 * 存在必然的耦合关系 不利于线程的重用
 */
class MyThread1 extends Thread{
    public void run(){
        for(int i =0;i<1000;i++){
            System.out.println("你是谁呀？");
        }
    }
}
class MyThread2 extends Thread{
    public void run(){
        for(int i =0;i<1000;i++){
            System.out.println("开门！查水表的");
        }
    }
}