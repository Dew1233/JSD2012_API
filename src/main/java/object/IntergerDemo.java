package object;

public class IntergerDemo {
    public static void main(String[] args) {
        dosome("hello");
        dosome(new Point(1,3));
        int d = 123;
        Integer i = new Integer(d);
        dosome(i);
    }


    public static void dosome(Object obj){

    }
}
