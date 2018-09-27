package redisson.start;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.IOException;

/**
 * Created by Mirana on 01/11/2017.
 * redisson wiki : https://github.com/redisson/redisson/wiki/2.-Configuration#26-single-instance-mode
 */
public class ConfigurationDemo {

    @Test
    public void configTest() throws IOException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://172.17.14.156:6379");
        config.toJSON();
        RedissonClient redisson = Redisson.create(config);
    }
}
