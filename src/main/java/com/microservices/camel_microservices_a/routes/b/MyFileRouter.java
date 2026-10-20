package com.microservices.camel_microservices_a.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:files/input")
                .log("File name: ${header.CamelFileName}")
                .to("file:files/output");
    }
}
