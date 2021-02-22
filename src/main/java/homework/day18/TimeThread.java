package homework.day18;

/**
 * 采用匿名内部类的方式创建2个线程，一个线程为计时线程，
 * 每隔2s输出当前时间的毫秒表示，
 * 另一个线程为前台线程，任务是线程开始，休眠10秒结束，当前台线程结束，计时线程也随之结束。请完成以上案例。
 */
public class TimeThread {
    public static void main(String[] args) {
        Thread conterh = new Thread(){
            public void run(){
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis());
                }

            }
        };
        Thread fronth = new Thread(){
          public void run(){
              try {
                  Thread.sleep(10000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };
        fronth.start();
        conterh.setDaemon(true);
        conterh.start();
    }
}
