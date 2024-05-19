package ru.pish.outadapter.camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SoapRequestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("spring-rabbitmq:{{spring.rabbitmq.template.exchange}}?queues={{spring.rabbitmq.queue.soap-receive-request}}&routingKey={{spring.rabbitmq.queue.soap-receive-request}}")
                .id("GetSoapRequestRoute")
                .streamCaching()

                .log(LoggingLevel.INFO,
                        "org.sour.{{service.name}}",
                        "{{service.name}} GOT_REQUEST_FROM_SOAP_QUEUE: success got prepared message from queue: {{spring.rabbitmq.queue.soap-receive-request}}" +
                                "\nMessageId: ${headers.header_messageId}" +
                                "\nDZO: ${headers.header_sourcePlatform}" +
                                "\nBody:\n${body}")

                .process("soapMapper");
    }
}
