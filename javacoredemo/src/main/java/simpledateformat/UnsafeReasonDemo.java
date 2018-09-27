package simpledateformat;

import org.junit.Test;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by Mirana on 2017/8/20.
 */
public class UnsafeReasonDemo {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        A a =new A(sdf);
        B b = new B(sdf);
    }
}
class A implements Runnable{
    private SimpleDateFormat sdf ;
    public A (SimpleDateFormat sdf){
        this.sdf= sdf;
    }
    public void run() {
        try {
            Thread.sleep(3000l);
            System.out.println("A:"+sdf.parse("1999-12-31"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class B implements Runnable{
    private SimpleDateFormat sdf ;
    public B (SimpleDateFormat sdf){
        this.sdf= sdf;
    }
    public void run() {
        System.out.println("B:"+sdf.format(new Date()));
    }
}
