package deaklock;

/**
 * Created by Mirana on 2017/8/16.
 */
public class Deadlock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        A a = new A(obj1,obj2);
        B b = new B(obj1,obj2);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();


    }
}
class A implements Runnable {
    private Object b ;
    private Object a ;

    public A(Object a,Object b){
        this.b = b;
        this.a = a;
    }
    public void run() {
        synchronized (b){
            System.out.println("A获取了b的引用");
            try {
                Thread.currentThread().sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a) {
                System.out.println("A获取的a的引用");
            }
        }
    }
}

class B implements Runnable{
    private Object a;
    private Object b;
    public B(Object a,Object b){
        this.a = a;
        this.b = b;
    }
    public void run() {
        synchronized (a){
            System.out.println("B获取a的引用");
            try {
                Thread.currentThread().sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b) {
                System.out.println("B获取b的引用");
            }
        }
    }
}