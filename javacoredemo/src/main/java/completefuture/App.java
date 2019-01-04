package completefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        String hello = CompletableFuture.completedFuture("Hello").get();
        System.out.println(hello);
    }

    @Test
    public void test1(){
        CompletableFuture.allOf()
    }
}
