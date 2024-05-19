package ru.pish.outadapter.camel.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.pish.outadapter.models.dto.EmployeesDTO;

@Slf4j(topic = "WriteDataIntoDbProcessor")
public class WriteDataIntoDbProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        EmployeesDTO body = exchange.getIn().getBody(EmployeesDTO.class);
        System.out.println(body);
    }
}



