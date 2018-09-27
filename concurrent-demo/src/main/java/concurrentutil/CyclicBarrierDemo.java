package concurrentutil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Mirana on 02/11/2017.
 * CyclicBarrier 达到下一步的所有条件没有完成，所有barrier上的线程等待
 */
public class CyclicBarrierDemo {

    static CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
        public void run() {
            System.out.println("total result: "+sum);
        }
    });
    static Object lock = new Object();
    static int sum = 0;
    class ThreadTest extends Thread {

        private int start;
        private int end;

        public ThreadTest(int s, int e ) {
            start = s;
            end = e;
        }

        public void run() {
            synchronized (lock) {
                for (; start <= end; start++) {
                    sum += start;
                }
                System.out.println("from "+Thread.currentThread().getName()+" sum="+sum);
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        CyclicBarrierDemo.ThreadTest a = demo.new ThreadTest(1,25);
        CyclicBarrierDemo.ThreadTest b = demo.new ThreadTest(26,50);
        CyclicBarrierDemo.ThreadTest c = demo.new ThreadTest(51,75);
        CyclicBarrierDemo.ThreadTest d = demo.new ThreadTest(76,100);
        a.start();
        b.start();
        c.start();
        d.start();
        Thread.yield();
    }



}
