package packa.zkclient;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperFactory {

    private static CountDownLatch latch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;

    public static ZooKeeper getZookeeper(){
        if(zooKeeper == null){
            try {
                zooKeeper = new ZooKeeper("0.0.0.0:62181", 60000, new ConnectedWatcher());
                latch.await();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return zooKeeper;

    }

    static class ConnectedWatcher implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(JSON.toJSON(watchedEvent));
            if(watchedEvent.getState()== Event.KeeperState.SyncConnected){
                latch.countDown();
            }
        }
    }
}
