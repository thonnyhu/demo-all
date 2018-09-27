package redis.concurrent;


import redis.clients.jedis.Jedis;

public class TestThread extends Thread{
    private Jedis jedis;
    public TestThread(Jedis jedis){
        this.jedis = jedis;
    }
    @Override
    public void run() {
        long result = 0;
        for (int i = 0; i < 5000; i++) {
            result = jedis.incr("aaa");
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Jedis jedis3 = new Jedis("127.0.0.1",32774);
        jedis3.del("aaa");
        Jedis jedis1 = new Jedis("127.0.0.1",32774);
        Jedis jedis2 = new Jedis("127.0.0.1",32774);
        TestThread test1 = new TestThread(jedis1);
        TestThread test2 = new TestThread(jedis2);
        test1.start();
        test2.start();
        try {
            test1.join();
            test2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String aaa = jedis3.get("aaa");
        System.out.println(aaa);
    }
}
