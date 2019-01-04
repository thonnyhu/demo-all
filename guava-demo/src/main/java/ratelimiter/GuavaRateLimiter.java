package ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class GuavaRateLimiter {

    private static final RateLimiter limiter = RateLimiter.create(10d);


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach((i) ->{executorService.submit(GuavaRateLimiter::test);
                                           try {
                                               TimeUnit.MILLISECONDS.sleep(10);
                                           } catch (InterruptedException e) {
                                               e.printStackTrace();
                                           }
                                       }

        );
    }

    public static void test() {
        try {
            boolean b = limiter.tryAcquire();
            if(b) {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("I am working ");
            }else {
                System.out.println("acquire failed ");
            }
        } catch (Exception e) {
            System.out.println("acquire failed ");
        }
    }
}
