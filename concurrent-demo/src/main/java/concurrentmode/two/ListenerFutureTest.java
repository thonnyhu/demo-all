package concurrentmode.two;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Mirana on 06/11/2017.
 * Futures.addCallback 可以用 ListenableFuture的 addListener 替换，底层都是用ListenableFutureTask的ExecutionList
去执行的
 */
public class ListenerFutureTest {

    final static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        {
            Long t1 = System.currentTimeMillis();

            ListenableFuture<Boolean> booleanListenableFuture = service.submit(new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    return true;
                }
            });

            Futures.addCallback(booleanListenableFuture, new FutureCallback<Boolean>() {
                public void onSuccess(@Nullable Boolean result) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("BooleanFuture: "+ result);
                }

                public void onFailure(Throwable t) {

                }
            },service);

            ListenableFuture<String> stringListenableFuture = service.submit(new Callable<String>() {
                public String call() throws Exception {
                    return "Hello World";
                }
            });

            Futures.addCallback(stringListenableFuture, new FutureCallback<String>() {
                public void onSuccess(@Nullable String result) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("stringFuture: "+ result);
                }

                public void onFailure(Throwable t) {

                }
            },service);

            ListenableFuture<Integer> integerListenableFuture = service.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    return new Random(100).nextInt(100);
                }
            });

            Futures.addCallback(integerListenableFuture, new FutureCallback<Integer>() {
                public void onSuccess(@Nullable Integer result) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("integerFuture: "+ result);
                }

                public void onFailure(Throwable t) {

                }
            },service);


            long end = System.currentTimeMillis();

            System.out.println("time: "+ (end-t1));
        }
    }
}
