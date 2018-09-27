package concurrentmode.three;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by Mirana on 16/11/2017.
 * ForkJoinPool 直接在main里实例化
 */
public class Main {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        int n = 500;
        long startTime = System.currentTimeMillis();
        EvaluateSum bigProblem = new EvaluateSum(n,1,n);
        EvaluateSumTask task = new EvaluateSumTask(bigProblem);
        ForkJoinPool pool = new ForkJoinPool(processors);
        pool.invoke(task);
        int result = task.result;
        System.out.println("Sum result: " + result);
        System.out.println("Elapsed Time: "+ (System.currentTimeMillis()-startTime));
    }

    @Test
    public void test(){
        int sum = 0;
        for (int i = 0; i <= 500; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
