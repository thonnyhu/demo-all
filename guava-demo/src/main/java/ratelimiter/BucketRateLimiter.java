package ratelimiter;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 漏桶
 */
public class BucketRateLimiter {

    private static final int BUCKET_LIMIT = 1000;
    private final RateLimiter limiter = RateLimiter.create(50000);//消费者的消费速度
    private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<>();
    private Monitor produceMonitor = new Monitor();

    private Monitor takeMonitor = new Monitor();

    public static void main(String[] args) {
        BucketRateLimiter bucketRateLimiter = new BucketRateLimiter();
        ExecutorService submitExecutor = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1; i++) {
            submitExecutor.submit(() -> {
                for (; ; ) {
                    bucketRateLimiter.submit(ThreadLocalRandom.current().nextInt());
                }
            });
        }

        ExecutorService takeExecutor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            takeExecutor.submit(() -> {
                for (; ; ) {
                    bucketRateLimiter.take();
                }
            });
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submit(Integer data) {
        if (produceMonitor.enterIf(produceMonitor.newGuard(() -> container.size() < BUCKET_LIMIT))) {
            try {
                container.offer(data);
                System.out.println(String.format("%s submit %d , now Container size is : %d", Thread.currentThread().getName(), data, container.size()));
            } finally {
                produceMonitor.leave();
            }
        } else {
            // 如果超限，这里处理
            System.out.println("out of limit");
        }
    }

    public void take() {
        if (takeMonitor.enterIf(takeMonitor.newGuard(() -> !container.isEmpty()))) {
            try {
                limiter.acquire();
                Integer peek = container.poll();
                System.out.println(String.format("%s peek %d , now Container size is : %d", Thread.currentThread().getName(), peek, container.size()));
            }finally {
                takeMonitor.leave();
            }
        } else {
            //当木桶的消费完后，可以消费那些降级存入MQ或者DB里面的数据
            System.out.println("container is empty");
        }
    }
}
