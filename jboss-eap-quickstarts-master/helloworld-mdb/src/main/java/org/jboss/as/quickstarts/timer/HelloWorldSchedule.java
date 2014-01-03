package org.jboss.as.quickstarts.timer;

import org.jboss.as.quickstarts.ejb.CustomerManagerEJB;
import org.jboss.as.quickstarts.model.Customer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;
import java.util.List;
import java.util.logging.Logger;

@Singleton
public class HelloWorldSchedule {
    private final static Logger LOGGER = Logger.getLogger(HelloWorldSchedule.class.toString());


    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/queue/HELLOWORLDMDBQueue")
    private Queue queue;

    private Connection connection = null;
    private Session session = null;
    MessageProducer messageProducer = null;

    @Inject
    private CustomerManagerEJB customerManager;


    @PostConstruct
    private void init() {

        try {
            Destination destination = queue;
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(destination);
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void finish(){
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    LOGGER.severe(e.getErrorCode());
                    //e.printStackTrace();
                }
            }
    }

    @Schedule(second="*/30", minute="*",hour="*", persistent=false)
    public void doWork(){

        List<Customer> listOfCustomers = customerManager.listCustomers();
        for (Customer customer : listOfCustomers){
            try {
            TextMessage message = session.createTextMessage();
            message.setText(customer.getEmail() );
            messageProducer.send(message);
            } catch (JMSException e) {
                LOGGER.severe(e.getErrorCode());
                //e.printStackTrace();
            }
        }
    }

}