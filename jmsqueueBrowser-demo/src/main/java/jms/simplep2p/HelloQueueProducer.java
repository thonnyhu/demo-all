package jms.simplep2p;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Mirana on 2017/5/5.
 */
public class HelloQueueProducer {
    public static void main(String[] args) {
        Connection connection = null;
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("queue1");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            producer.setDisableMessageID(true);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("Hello from queue1 ");
            producer.send(textMessage);
        }catch (JMSException ex){

        }finally {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
