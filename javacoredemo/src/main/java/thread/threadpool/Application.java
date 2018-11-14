package thread.threadpool;

import java.util.concurrent.*;

public class Application {


    public static void main(String[] args) {
        Integer poolSize = 5;
        if (null == poolSize) {
            poolSize = 5;
        }
        Integer queueSize = 5;
        if (null == queueSize) {
            queueSize = 5;
        }
        //CountDownLatch countDownLatch = new CountDownLatch(1200);
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(queueSize);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize, poolSize, 0, TimeUnit.SECONDS, queue, handler);
        for (int i = 0; i < 1200; i++) {
            try {
                final int a = i;
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("[updateAllPoiShopTag]thread=" + Thread.currentThread().getName() + ", i = " + a);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //countDownLatch.countDown();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        //try {
            //countDownLatch.await();
        //} catch (InterruptedException e) {
         //   e.printStackTrace();
        //}
        System.out.println("shutdown!!!!");
    }
}
