package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mirana on 15/11/2017.
 * 关于子线程在父线程挂掉时的中表现问题的例子
 */
public class ParentChildThread extends Thread{

    @Override
    public void run() {

        ChildThread child = new ChildThread();
        child.setDaemon(false);
        child.start();
        System.out.println("父线程"+ getName()+": 执行结束" );
    }

    public static void main(String[] args) throws InterruptedException {

        new ParentChildThread().start();
        System.out.println("主线程开始休眠");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("断点查看线程状态");
    }
}


class ChildThread extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("子线程开始执行");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("子线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}