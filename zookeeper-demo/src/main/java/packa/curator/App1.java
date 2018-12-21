package packa.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

public class App1 {

    public static void main(String[] args) {
        CuratorFramework client = null;
        try{
            client = CuratorFrameworkFactory.newClient("0.0.0.0:62181",new ExponentialBackoffRetry(300,5));
            client.start();
            String s = client.create().withMode(CreateMode.PERSISTENT).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath("/curator/node1", "hello curator".getBytes());
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

}
