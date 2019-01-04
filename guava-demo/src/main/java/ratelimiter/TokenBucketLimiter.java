package ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class TokenBucketLimiter {


    private RateLimiter limiter = RateLimiter.create(10);


    public void buy(){
        boolean b = limiter.tryAcquire(10, TimeUnit.SECONDS);
        if(!b){
            System.out.println("try again");
        }else {

        }

    }
}
