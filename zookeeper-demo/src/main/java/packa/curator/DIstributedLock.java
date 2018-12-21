package packa.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import java.util.concurrent.TimeUnit;

public class DIstributedLock {

    public static void main(String[] args) {
        CuratorFramework client = null;
        try{
            client = CuratorFrameworkFactory.newClient("0.0.0.0:62181", new ExponentialBackoffRetry(300, 5));
            client.start();

            InterProcessMutex mutex = new InterProcessMutex(client,"/curator/mutex");
            if(mutex.acquire(3000, TimeUnit.MILLISECONDS)){
                try{
                    System.out.println("acquired the lock");
                }finally {
                    mutex.release();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }
}
