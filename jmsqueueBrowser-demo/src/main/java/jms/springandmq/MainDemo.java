package jms.springandmq;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * Created by Mirana on 2017/5/8.
 */
public class MainDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:springandmq/spring-activemq.xml");
        Queue1Sender sendDemo = (Queue1Sender) ctx.getBean("sendDemo");
        long l = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            sendDemo.sendMessage();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-l);
    }
}
