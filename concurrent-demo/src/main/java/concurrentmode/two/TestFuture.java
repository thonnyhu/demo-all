package concurrentmode.two;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Mirana on 06/11/2017.
 */
public class TestFuture {

    final static Executor executor = Executors.newCachedThreadPool();
    final static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Long t1 = System.currentTimeMillis();

        Future<Boolean> booleanFuture = executorService.submit(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return true;
            }
        });

        while (true){
            if (booleanFuture.isDone() && !booleanFuture.isCancelled()){
                Thread.sleep(500);
                Boolean aBoolean = booleanFuture.get();
                System.out.println("BooleanFuture: "+ aBoolean);
                break;
            }
        }

        Future<String> stringFuture = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                return "Hello World";
            }
        });

        while (true){
            if (stringFuture.isDone() && !stringFuture.isCancelled()){
                Thread.sleep(500);
                String string = stringFuture.get();
                System.out.println("stringFuture: "+ string);
                break;
            }
        }

        Future<Integer> integerFuture = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random(100L).nextInt(100);
            }
        });

        while (true){
            if (integerFuture.isDone() && !integerFuture.isCancelled()){
                Thread.sleep(500);
                Integer integer = integerFuture.get();
                System.out.println("integerFuture: "+ integer);
                break;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("time: "+ (end-t1));
    }
}
