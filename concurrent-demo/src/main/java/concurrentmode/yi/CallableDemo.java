package concurrentmode.yi;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

/**
 * Created by Mirana on 03/11/2017.
 */
public class CallableDemo implements Callable<Integer>{

    private int sum;

    public Integer call() throws Exception {
        System.out.println("Callable子线程开始了..");
        sleep(2000);

        for (int i = 0; i < 5000; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
