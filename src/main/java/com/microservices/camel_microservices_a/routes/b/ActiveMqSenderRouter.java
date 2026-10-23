package com.microservices.camel_microservices_a.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


public class ActiveMqSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //timer
            from("timer:active-mq-timer?period=10000")
                .transform().constant("My message for Active MQ")
                    .log("Message sent to Active MQ: ${body}")
                    .to("activemq:my-activemq-queue");
        //queue
    }
}
