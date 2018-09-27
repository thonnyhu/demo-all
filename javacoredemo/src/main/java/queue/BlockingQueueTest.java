package queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Mirana on 2017/8/23.
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blQ = new LinkedBlockingQueue<Integer>(10);
        for(int i = 0; i< 10 ;i++){
            if(i<5) {
                new Thread(new Producer(blQ),"Producer"+i).start();
            }else{
                new Thread(new Consumer(blQ),"Consumer"+(i-5)).start();
            }
        }

        Thread.sleep(100000l);
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;
    private volatile boolean flag;
    private Random random;

    public Producer(BlockingQueue<Integer> blQ) {
        this.blockingQueue = blQ;
        flag = false;
        random = new Random();
    }

    public void run() {
        while (!flag) {
            int info = random.nextInt(100);
            blockingQueue.offer(info);
            System.out.println(Thread.currentThread().getName() + " produce " + info);
            try {
                Thread.sleep(50l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void shutdown(){
        flag = true;
    }
}

class Consumer implements Runnable{
    private final BlockingQueue<Integer> blockingQueue;
    private volatile boolean flag;

    public Consumer(BlockingQueue<Integer> blq){
        blockingQueue = blq;
        flag = false;
    }
    public void run() {
        while (!flag){
            int info;
            info = blockingQueue.poll();
            System.out.println(Thread.currentThread().getName()+" consume " + info);
            try {
                Thread.sleep(50l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        flag = true;
    }
}
