package bytecodeoflock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {

    private static AtomicInteger count = new AtomicInteger(1);


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread a = new Thread(new Runnable() {
            public void run() {
                int i = count.get();
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (!count.compareAndSet(i, 10)){}

                System.out.println("线程1执行完毕");
            }
        });
        Thread b = new Thread(new Runnable() {
            public void run() {
                int i = count.get();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                boolean b = count.compareAndSet(i, 10);

                System.out.println("线程2执行完毕");
            }
        });
        a.start();
        b.start();
        TimeUnit.SECONDS.timedJoin(a,20);
        TimeUnit.SECONDS.timedJoin(b,20);
        long end = System.currentTimeMillis();
        System.out.println("程序结束,总共执行："+(end-start));
    }
}
