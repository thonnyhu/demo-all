package packa.zkclient;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 并发创建节点
 */
public class App2 {


    private static CyclicBarrier barrier = new CyclicBarrier(10);


    public static void main(String[] args) {
        for (int i = 0 ; i< 10 ; i++){
            new Thread(new Worker(i)).start();
        }
    }

    static class Worker implements Runnable{
        private static String path = "/node2";
        private int i;
        public Worker(int i){
            this.i = i;
        }
        @Override
        public void run() {
            try {
                System.out.println(barrier.getParties());
                barrier.await();
                ZooKeeper zookeeper = ZookeeperFactory.getZookeeper();
                if(zookeeper.exists(path,false) == null){
                   zookeeper.create(path, ("Hello World"+i).getBytes() , ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
    }
}
