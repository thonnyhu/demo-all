package jms.springandmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import sun.security.krb5.internal.crypto.Des;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Mirana on 2017/5/8.
 */
public class Queue1Sender implements ActiveMqSender{

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    private Destination destination;
    private final String message;
    public Queue1Sender (Destination destination , String message){
        this.destination = destination;
        this.message = message;
    }

    public void sendMessage() {
       jmsTemplate.send(destination, new MessageCreator() {
           public Message createMessage(Session session) throws JMSException {
               return session.createTextMessage(message);
           }
       });
    }

}
