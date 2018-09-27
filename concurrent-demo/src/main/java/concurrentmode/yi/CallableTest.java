package concurrentmode.yi;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

/**
 * Created by Mirana on 03/11/2017.
 */
public class CallableTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CallableDemo demo = new CallableDemo();

        Future<Integer> future = executorService.submit(demo);

        executorService.shutdown();

        System.out.println("主线程在找妹子");
        sleep(2000);

        if(future.get()!=null)
            System.out.println("future.get()-->"+ future.get());

        System.out.println("finish .");
    }
}
