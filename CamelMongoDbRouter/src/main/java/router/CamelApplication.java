package router;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import org.slf4j.*;
import org.apache.camel.*;
import org.apache.camel.builder.*;
import org.apache.camel.main.Main;

public class CamelApplication extends Main{
    static Logger LOG = LoggerFactory.getLogger(CamelApplication.class);
    private static final String host = "localhost";
    public static void main(String[] args) throws Exception {
        Mongo client = new Mongo("localhost", 27017);
        DBObject ping = new BasicDBObject("ping", "1");
        try {
            client.getDB("test").command(ping);
        } catch (MongoException e) {
            LOG.error("Mongodb is down : " + e.getStackTrace());
            return;
        }
        CamelApplication main = new CamelApplication();
        main.enableHangupSupport();
        main.bind("myDb", client);
        main.addRouteBuilder(createRouteBuilder());
        main.run(args);
    }

    static RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                  from("rabbitmq://localhost/test?exchangeType=direct&durable=true&autoDelete=false&routingKey=test&" +
                          "username=guest&password=guest&queue=MessageRepository.DefaultConsumer.durable")
                          .convertBodyTo(String.class)
                  .process(new Processor() {
                      public void process(Exchange exchange) throws Exception {
                          if (!exchange.hasOut()) {
                              exchange.setOut(exchange.getIn());
                          }
                          if (exchange.hasOut()) {
                              String msgid = exchange.getOut().getMessageId();
                              String msgbody = (String) exchange.getOut().getBody();

                              BasicDBObject document = new BasicDBObject();
                              exchange.getOut().getBody();
                              document.put(msgid, msgbody);
                              exchange.getOut().setBody(document);
                              //LOG.info(msgid + " " + msgbody);
                          }
                      }
                  }
                  )
                  .to("mongodb:myDb?database=test&collection=testCollection&operation=insert");
            }
            };
    }
}
