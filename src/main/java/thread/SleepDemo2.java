package thread;

/**
 * sleep方法要求必须处理中断异常（Thread提供了其他会导致线程阻塞的方法，很多都要求处理这个
 * 异常情况是一样的）
 *
 * 当一个线程调用sleep方法处于睡眠阻塞的过程中，此刻线程的interrupt方法
 * 被调用时候，会中断这个阻塞过程，此时该方法会抛出中断异常
 */
public class SleepDemo2 {
    public static void main(String[] args) {
     Thread lin = new Thread(){
         public void run(){
             System.out.println("刚刚美完容，睡一会儿吧");
             try {
                 Thread.sleep(600000);
             } catch (InterruptedException e) {
                 System.out.println("林：干嘛呢？干嘛呢？都破了相了");
             }
             System.out.println("林：醒了");
         }
     };

     Thread huang = new Thread(){
         public void run(){
             System.out.println("黄：大锤80，小锤40,开始砸墙");
             for (int i =0;i<5;i++){
                 System.out.println("黄：八十八十");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                 }
             }
             System.out.println("咣当");
             System.out.println("黄：搞定");
             lin.interrupt();
         }
     };
     lin.start();
     huang.start();



    }
}
