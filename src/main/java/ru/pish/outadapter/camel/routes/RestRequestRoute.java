package ru.pish.outadapter.camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import ru.pish.outadapter.models.dto.EmployeesDTO;

@Component
public class RestRequestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("spring-rabbitmq:{{spring.rabbitmq.template.exchange}}?queues={{spring.rabbitmq.queue.rest-receive-request}}&routingKey={{spring.rabbitmq.queue.rest-receive-request}}")
                .unmarshal().json(JsonLibrary.Jackson, EmployeesDTO.class)
                .id("GetRestRequestRoute")
                .streamCaching()

                .log(LoggingLevel.INFO,
                        "org.sour.{{service.name}}",
                        "{{service.name}} GOT_REQUEST_FROM_REST_QUEUE: success got prepared message from queue: {{spring.rabbitmq.queue.rest-receive-request}}" +
                                "\nMessageId: ${headers.header_messageId}" +
                                "\nDZO: ${headers.header_sourcePlatform}" +
                                "\nBody:\n${body}")

                .process("restMapper");
    }
}
