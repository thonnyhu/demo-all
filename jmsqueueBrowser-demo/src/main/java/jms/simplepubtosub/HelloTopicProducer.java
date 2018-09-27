package jms.simplepubtosub;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Mirana on 2017/5/6.
 */
public class HelloTopicProducer {
    public void send(String msg){
        Connection connection = null;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("topic1");
            MessageProducer producer = session.createProducer(destination);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            Message message = session.createMessage();
            message.setStringProperty("abc",msg);

            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new HelloTopicProducer().send("你好,From pub");
    }
}
