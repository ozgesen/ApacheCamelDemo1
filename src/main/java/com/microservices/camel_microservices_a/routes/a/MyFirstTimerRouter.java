package com.microservices.camel_microservices_a.routes.a;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLoggingProcessingComponent loggingComponent;

    public void configure() {
        from("timer:first-timer")
                .log("${body}")
                .transform().constant("My First Timer")
                .log("${body}")
                //.bean("getCurrentTimeBean")
                //.bean(getCurrentTimeBean, "getCurrentTime")
                .bean(getCurrentTimeBean)
                .log("${body}")
                .bean(loggingComponent)
                .process(new SimpleLoggingProcessor())
                .to("log:first-timer");
    }
}


class SimpleLoggingProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessor.class);
        logger.info("SimpleLoggingProcessor: {}", exchange.getMessage().getBody());
    }
}

@Component
class GetCurrentTimeBean {
    public String getCurrentTime() {
        return "Time now is " + java.time.LocalDateTime.now();
    }
}

@Component
class SimpleLoggingProcessingComponent {

    private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);

    public void process(String message) {
        logger.info("SimpleLoggingProcessingComponent: {}", message);
    }
}
