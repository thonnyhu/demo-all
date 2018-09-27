import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by Mirana on 2017/8/25.
 * Simple EventBus
 */
public class SyncEventBus {

    public static void main(String[] args) {
        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();

        EventBusCenter.register(observer1);
        EventBusCenter.register(observer2);

        System.out.println("============   start  ====================");

        // 只有注册的参数类型为String的方法会被调用
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);

        System.out.println("============ after unregister ============");
        // 注销observer2
        EventBusCenter.unRegister(observer2);
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);


    }

}

class EventBusCenter{
    private static EventBus eventBus = new EventBus();
    private EventBusCenter(){

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

class DataObserver1{

    @Subscribe
    public void func(String msg){
        System.out.println("msg:"+msg);
    }
}

class DataObserver2{

    @Subscribe
    public void func(Integer i){
        System.out.println("Integer msg:"+ i);
    }
}