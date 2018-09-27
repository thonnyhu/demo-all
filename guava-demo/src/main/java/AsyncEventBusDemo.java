import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * Created by Mirana on 2017/8/25.
 * Simple EventBus
 */
public class AsyncEventBusDemo {

    public static void main(String[] args) {
        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();

        AsyncEventBusCenter.register(observer1);
        AsyncEventBusCenter.register(observer2);

        System.out.println("============   start  ====================");

        // 只有注册的参数类型为String的方法会被调用
        AsyncEventBusCenter.post("post string method");
        AsyncEventBusCenter.post(123);

        System.out.println("============ after unregister ============");
        // 注销observer2
        AsyncEventBusCenter.unRegister(observer2);
        AsyncEventBusCenter.post("post string method");
        AsyncEventBusCenter.post(123);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class AsyncEventBusCenter{
    private static EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));
    private AsyncEventBusCenter(){

    }

    public static EventBus getInstance(){
        return eventBus;
    }

    public static void register(Object obj){
        eventBus.register(obj);
    }

    public static void unRegister(Object obj){
        eventBus.unregister(obj);
    }

    public static void post(Object obj){
        eventBus.post(obj);
    }
}
