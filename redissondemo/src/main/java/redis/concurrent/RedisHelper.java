package redis.concurrent;

import redis.clients.jedis.Jedis;

public class RedisHelper {
    private Jedis jedis ;
    public RedisHelper(){
        jedis =  new Jedis("127.0.0.1",32774);
    }


}
