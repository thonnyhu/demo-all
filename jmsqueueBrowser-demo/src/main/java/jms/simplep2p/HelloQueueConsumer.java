package jms.simplep2p;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Mirana on 2017/5/6.
 */
public class HelloQueueConsumer implements MessageListener {
    public static void main(String[] args) {
       new HelloQueueConsumer().receive();
    }

    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage txtMsg = (TextMessage)message;
            try{
                System.out.println("HaHa: I'v got " + txtMsg.getText());
            }catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public void receive(){
        Connection connection = null;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("queue1");
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(this);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
