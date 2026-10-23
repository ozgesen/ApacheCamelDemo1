package com.microservices.camel_microservices_a.routes.a;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.apache.camel.support.AsyncProcessorHelper.process;


@Component
public class MyFirstTimerRouter extends RouteBuilder  {

    BindyCsvDataFormat bindy = new BindyCsvDataFormat (com.microservices.camel_microservices_a.routes.a.Order.class);
    BindyCsvDataFormat bindyOutput = new BindyCsvDataFormat (com.microservices.camel_microservices_a.routes.a.OrderOutput.class);
    JaxbDataFormat jaxbDataFormat =  new JaxbDataFormat(JAXBContext.newInstance(OrderOutput.class));

    public MyFirstTimerRouter() throws JAXBException {
    }


    public void configure() {

        from("file:C:\\Users\\OzgeColak\\OneDrive - DefineX\\Desktop\\Projects\\camel-microservices-a\\src\\main\\resources\\input1?fileName=exampleOrders.txt&noop=true")
                //.split(body().tokenize("\n", 3, false)).streaming()
                .log("${body}")
                .unmarshal(bindy)
                .log("${body}")
                .process(exchange -> {
                    List<Order> orders = exchange.getMessage().getBody(List.class);
                    List<OrderOutput> orderOutputs = new ArrayList<OrderOutput>(orders.size());
                    Orders orderList = new Orders();
/*
                    for (Order order : orders) {
                        OrderOutput orderOutput = new OrderOutput();
                        orderOutput.setFirstName(order.getFirstName().toUpperCase());
                        orderOutput.setLastName(order.getLastName().toUpperCase());
                        orderOutput.setEmail(order.getEmail());
                        orderOutput.setItem(order.getItem());
                        orderOutput.setOrderId(order.getOrderId());
                        orderOutput.setPrice(order.getPrice().multiply(new java.math.BigDecimal("1")));
                        orderOutput.setFlag("Processed");
                        orderOutputs.add(orderOutput);
                    }

                    exchange.getMessage().setBody(orderOutputs);


                    */
                            for (Order order : orders) {
                                OrderOutput orderOutput = new OrderOutput();
                                orderOutput.setFirstName(order.getFirstName().toUpperCase());
                                orderOutput.setLastName(order.getLastName().toUpperCase());
                                orderOutput.setEmail(order.getEmail());
                                orderOutput.setItem(order.getItem());
                                orderOutput.setOrderId(order.getOrderId());
                                orderOutput.setPrice(order.getPrice().multiply(new java.math.BigDecimal("1")));
                                orderOutput.setFlag("Processed");
                                orderOutputs.add(orderOutput);
                            }
                            orderList.setOrders(orderOutputs);
                            //exchange.getMessage().setBody(orderOutputs);
                            exchange.getMessage().setBody(orderList);
                }
                 )

                .marshal(jaxbDataFormat)
                .log("Demo App ${body}")
                .setHeader("CamelFileName", constant("processedOrders3.txt"))
                .to("file:C:\\Users\\OzgeColak\\OneDrive - DefineX\\Desktop\\Projects\\camel-microservices-a\\src\\main\\resources\\output?fileExist=Append");
                //.end();

                //.transform().constant("My First Message")
                //.log("${body}")

        // Input file .csv
        //1 xsd
        //generate the classes from xsd
        // jaxb from xsd definition
}}


