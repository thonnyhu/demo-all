package cgliborjdk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");
        Object b = ctx.getBean("b");
        System.out.println(b.toString());
    }
}
