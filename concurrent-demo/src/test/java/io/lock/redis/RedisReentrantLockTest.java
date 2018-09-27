package io.lock.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

/**
 * Created by Mirana on 2017/4/18.
 */
public class RedisReentrantLockTest {
    @Test
    public void lock() throws Exception {
        Jedis jedis = new Jedis("127.0.0.1");
        String s = jedis.time().get(0);
        System.out.println(s);
//        Thread.sleep(10000);
        s = jedis.time().get(0);
        System.out.println(s);
        s = String.valueOf(System.currentTimeMillis());
        System.out.println(s);
//        RedisReentrantLock rrl = new RedisReentrantLock(jedis);
//        rrl.tryLock();
//        rrl.unlock0();
    }

    @Test
    public void tryLock() throws Exception {

    }

    @Test
    public void isLocked() throws Exception {

    }

    @Test
    public void unlock0() throws Exception {

    }

    @Test
    public void release() throws Exception {

    }

    @Test
    public void isHeldByCurrentThread() throws Exception {

    }

}