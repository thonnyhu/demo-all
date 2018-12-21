package packa.zkclient;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * first
 */
public class App1 {




    private ZooKeeper zooKeeper;

    @Before
    public void init(){
        try {
            zooKeeper = new ZooKeeper("0.0.0.0:62181", 60000, new ConnectedWatcher());
            latch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createPersistentNode(){
        Stat exists = null;
        try {
            for(int i= 1; i<= 10 ; i++) {
                exists = zooKeeper.exists("/node1/"+i, false);
                if (exists == null) {
                    zooKeeper.create("/node1/"+i, ("nihao"+i).getBytes(), OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createEphemeralNode(){
        CreateMode createMode = CreateMode.EPHEMERAL_SEQUENTIAL;
        Stat exists = null;
        try {
            String path = "/node1/seq1";
            exists = zooKeeper.exists(path, false);
            if(exists == null){
                zooKeeper.create(path, "nihao".getBytes(), OPEN_ACL_UNSAFE, createMode);
            }
            Stat stat = new Stat();
            byte[] data = zooKeeper.getData("/node1/seq10000000002", false, stat);
            System.out.println(new String(data));
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getChildren(){
        String path = "/node1";
        try {
            List<String> children = zooKeeper.getChildren(path, false);
            System.out.println(children.toString());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static CountDownLatch latch = new CountDownLatch(1);


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
