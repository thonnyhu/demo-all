package activemq.virtualtopic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Mirana on 02/11/2017.
 * 虚拟队列，同组只有一个会消费
 */
public class Consumer {

    public static void main(String[] args) throws JMSException, InterruptedException {
        // 连接到ActiveMQ服务器
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://172.17.14.156:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        // 创建主题
        Queue topicA = session.createQueue("Consumer.A.VirtualTopic.TEST");
        Queue topicB = session.createQueue("Consumer.B.VirtualTopic.TEST");
        // 消费者A组创建订阅
        MessageConsumer consumerA1 = session.createConsumer(topicA);

        MessageConsumer consumerA2 = session.createConsumer(topicA);

        //消费者B组创建订阅
        MessageConsumer consumerB1 = session.createConsumer(topicB);

        MessageConsumer consumerB2 = session.createConsumer(topicB);


        consumerA1.setMessageListener(new MessageListener() {
            // 订阅接收方法
            public void onMessage(Message message) {
                TextMessage tm = (TextMessage) message;
                try {
                    System.out.println("Received message A1: " + tm.getText()+":"+tm.getStringProperty("property"));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        consumerA2.setMessageListener(new MessageListener() {
            // 订阅接收方法
            public void onMessage(Message message) {
                TextMessage tm = (TextMessage) message;
                try {
                    System.out.println("Received message A2: " + tm.getText()+":"+tm.getStringProperty("property"));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

//        consumerB1.setMessageListener(new MessageListener() {
//            // 订阅接收方法
//            public void onMessage(Message message) {
//                TextMessage tm = (TextMessage) message;
//                try {
//                    System.out.println("Received message B1: " + tm.getText()+":"+tm.getStringProperty("property"));
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        consumerB2.setMessageListener(new MessageListener() {
//            // 订阅接收方法
//            public void onMessage(Message message) {
//                TextMessage tm = (TextMessage) message;
//                try {
//                    System.out.println("Received message B2: " + tm.getText()+":"+tm.getStringProperty("property"));
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });




        Thread.sleep(1000000);
    }
}
