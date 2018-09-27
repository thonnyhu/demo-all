package dubbospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Mirana on 2017/8/29.
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("spring-provider.xml");
        cpx.start();
        System.in.read();
    }
}
