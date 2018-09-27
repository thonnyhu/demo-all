package dubbospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mirana on 2017/8/29.
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        cpx.start();
        IPersonService personService = (IPersonService) cpx.getBean("consumerService");
        System.out.println(personService.getPersonName("111").toString());
        System.out.println(personService.getPersonName(null));
    }
}
