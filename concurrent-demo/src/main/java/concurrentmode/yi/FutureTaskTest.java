package concurrentmode.yi;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

/**
 * Created by Mirana on 03/11/2017.
 */
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        CallableDemo demo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(demo);
        es.submit(futureTask);
        es.shutdown();



        if(futureTask.get()!=null) {
            System.out.println("主线程泡妹子去了");
            sleep(2000);
            System.out.println("futureTask --> " + futureTask.get());
        }

        System.out.println("finish.");
    }
}
