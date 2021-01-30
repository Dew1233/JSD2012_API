package expection;
/*
异常处理机制中的try-catch

 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try{
            String str = "abc";
             /*
        如果str为null时，当虚拟机执行到下面的代码会发现这里存在空指针现象
        于是虚拟机会实例化一个空指针异常的实例，将其抛出。抛出后会检查报错
        的这句话是否被异常处理机制控制，如果没有则会将该异常抛出到当前方法
        外面由该方法的代码去解决（这里相当于抛出到main方法外面)
        * */
            System.out.println(str.length());
            System.out.println(str.charAt(0));
            System.out.println(Integer.parseInt(str));
//            try语句块中报错代码以下内容都不会被执行！！！
            System.out.println("!!!!!!!!!");
//            catch用来捕获try中出现的指定异常并予以解决
        }catch(NullPointerException e){
            System.out.println("出现了空指针");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("字符串下标越界了");
        }catch (NumberFormatException e){
            System.out.println("数字格式异常");

            /*
            catch超类异常的意义：
            当try中某几类异常希望使用相同处理办法时候，可以catch这些
            异常的超类。
            在最后一个catch处捕获Exception也可以避免因为一个未处理
            的异常导致程序中断
            当多个catch的异常之间存在继承关系的时候，子类型异常要在
            上面先行捕获，超类异常在下，否则编译不通过
            */
        }catch (Exception e){
            System.out.println("当前程序遇到一个未知错误");
        }


        System.out.println("程序结束了");
    }
}
