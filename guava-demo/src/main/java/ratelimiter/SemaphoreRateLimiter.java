package ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreRateLimiter {

    private static final Semaphore sep = new Semaphore(3);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach((i) ->
                                               executorService.submit(SemaphoreRateLimiter::test)
        );
    }

    public static void test() {
        try {
            boolean b = sep.tryAcquire(100, TimeUnit.MILLISECONDS);
            if(b) {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("I am working ");
            }else {
                System.out.println("acquire failed ");
            }
        } catch (Exception e) {
            System.out.println("acquire failed ");
        } finally {
            sep.release();
        }
    }
}
