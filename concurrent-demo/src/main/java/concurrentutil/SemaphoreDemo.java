package concurrentutil;

import java.util.concurrent.Semaphore;

/**
 * Created by Mirana on 02/11/2017.
 * Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        int N = 8 ;
        Semaphore semaphore = new Semaphore(5);
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;

        public Worker(int num , Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try{
                semaphore.acquire();
                System.out.println("工人"+ this.num + "占用一个机器在生产...");
                sleep(300);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
