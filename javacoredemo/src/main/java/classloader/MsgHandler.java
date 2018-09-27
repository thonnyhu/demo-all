package classloader;

/**
 * Created by Mirana on 07/11/2017.
 */
public class MsgHandler implements Runnable{
    @Override
    public void run() {
        while (true){
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

//        System.out.println(System.getProperty("user.dir"));
        new Thread(new MsgHandler()).start();
    }
}
