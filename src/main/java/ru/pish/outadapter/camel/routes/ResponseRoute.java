package ru.pish.outadapter.camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ResponseRoute extends RouteBuilder {
    private final String CHARSET = "UTF-8";
    @Override
    public void configure() throws Exception {
        from("direct:sendResponseDirect")
                .id("responseToroOrderRoute")
                .streamCaching()

                .removeHeaders("*", "header_*")
                .setProperty("CamelRabbitmqDeliveryMode", simple("2"))
                .convertBodyTo(String.class, CHARSET)

                .wireTap("spring-rabbitmq:{{spring.rabbitmq.template.exchange}}?queues={{spring.rabbitmq.queue.response-queue}}&routingKey={{spring.rabbitmq.queue.response-queue}}")

                .log(LoggingLevel.INFO,
                        "org.sour.{{service.name}}",
                        "{{service.name}} CREATE_RESPONSE_: success create response message." +
                                "\nMessageId: ${headers.header_messageId}" +
                                "\nDZO: ${headers.header_sourcePlatform}" +
                                "\nBody:\n${body}");

    }
}
