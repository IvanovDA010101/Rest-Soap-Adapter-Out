package ru.pish.outadapter.camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ResponseToroOrderRoute extends RouteBuilder {
    private final String CHARSET = "UTF-8";
    @Override
    public void configure() throws Exception {
        from("direct:sendResponseDirect")
                .id("responseToroOrderRoute")
                .streamCaching();

//                .removeHeaders("*", "header_*")
//                .setProperty("CamelRabbitmqDeliveryMode", simple("2"))
//                .convertBodyTo(String.class, CHARSET)
//
//                .wireTap("spring-rabbitmq:{{spring.rabbitmq.template.exchange}}?queues={{spring.rabbitmq.queue.toro-orders-response}}&routingKey={{spring.rabbitmq.queue.toro-orders-response}}")
//
//                .log(LoggingLevel.INFO,
//                        "org.sour.{{service.name}}",
//                        "{{service.name}} CREATE_RESPONSE_TORO_ORDERS_FOR_SUPA: success create response ToroOrders message." +
//                                "\nMessageId: ${headers.header_messageId}" +
//                                "\nDZO: ${headers.header_sourcePlatform}" +
//                                "\nBody:\n${body}");

    }
}
