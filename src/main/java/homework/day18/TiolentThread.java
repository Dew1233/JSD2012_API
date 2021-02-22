package homework.day18;

/**
 * 创建2个线程对象表示2个人，二人都要完成在客厅看电视5s，然后去卫生间5s的任务，已知二人同时开始执行任务。
 * 	要求：2个人可以同时在客厅看电视，但是上厕所不能同时上，只能排队上
 * 		提示：synchronized
 */
public class TiolentThread {
    public static void main(String[] args) {
        Play play = new Play();
        Thread t1 = new Thread(){
            public void run(){
                play.task();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                play.task();
            }
        };
        t1.start();
        t2.start();
    }
}
class Play{
    public void task()  {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+"正在看电视");
            Thread.sleep(5000);
            synchronized (this) {
                System.out.println(t.getName() + "正在上厕所");
                Thread.sleep(5000);
            }
            System.out.println(t.getName()+"结束任务");
        } catch (InterruptedException e) {

        }

    }
}
