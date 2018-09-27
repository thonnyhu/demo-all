package bytecodeoflock;

/**
 * Created by Mirana on 20/11/2017.
 * 通过javap 查看到，sync的字节码中会有monitorenter 和 monitorexit
 */
public class SyncByteCodeDemo {
    public static void main(String[] arg){
        Runnable t1=new MyThread();
        new Thread(t1,"t1").start();
        new Thread(t1,"t2").start();
    }
}

class MyThread implements Runnable {

    public void run() {
        synchronized (this) {
            for(int i=0;i<10;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }

}
