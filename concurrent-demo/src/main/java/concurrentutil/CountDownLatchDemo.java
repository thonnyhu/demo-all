package concurrentutil;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Mirana on 02/11/2017.
 * 多线程完成计算
 * 等待条件达成主线程继续走
 * CountDownLatch
 */
public class CountDownLatchDemo {

    static CountDownLatch latch = new CountDownLatch(3);
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
            latch.countDown();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        ThreadTest a = demo.new ThreadTest(1,25);
        ThreadTest b = demo.new ThreadTest(26,50);
        ThreadTest c = demo.new ThreadTest(51,75);
        ThreadTest d = demo.new ThreadTest(76,100);
        a.start();
        b.start();
        c.start();
        d.start();

        latch.await();
        System.out.println("total result: "+sum);
    }


}
