package bytecodeoflock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mirana on 20/11/2017.
 * javap -v 查看的字节码是 getfield 、 invokeinterface
 */
public class ReentrantLockCodeDemo {
    public static void main(String[] args) {
        Runnable t1=new MyThread2();
        new Thread(t1,"t1").start();
        new Thread(t1,"t2").start();

    }
}


class MyThread2 implements Runnable {

    private Lock lock=new ReentrantLock();
    public void run() {
        lock.lock();
        try{
            for(int i=0;i<5;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }finally{
            lock.unlock();
        }
    }

}