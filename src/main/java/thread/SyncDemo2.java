package thread;

/**
 * 有效的缩小同步范围可以在保证并发安全的前提下提高并发的效率
 * 同步块：
 * synchronized(同步监视器对象){
 *     需要多线程同步执行的代码片段
 * }
 * 同步块可以更准确的锁定需要同步执行的代码片段
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread t1 = new Thread(){
            public void run(){
              shop.buy();
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                shop.buy();
            }
        };

        t1.start();
        t2.start();
    }
}
class Shop{
    public  void buy(){

        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+":正在挑衣服……");
            Thread.sleep(5000);
//
            synchronized(this){
                System.out.println(t.getName()+":正在试衣服……");
                Thread.sleep(5000);
            }
            System.out.println(t.getName()+":结账离开！");
        } catch (Exception e) {

        }
    }

}