package ru.pish.outadapter.camel.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pish.outadapter.models.dto.EmployeesDTO;
import ru.pish.outadapter.services.RestEmployeeService;

@Component
@Slf4j(topic = "RestMapper")
public class RestMapper implements Processor {

    @Autowired
    private RestEmployeeService restEmployeeService;

    @Override
    public void process(Exchange exchange) throws Exception {
        EmployeesDTO body = exchange.getIn().getBody(EmployeesDTO.class);
        restEmployeeService.writeEmployee(body);
    }

}
