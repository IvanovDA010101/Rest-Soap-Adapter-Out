package ru.pish.outadapter.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pish.education.Employees;
import ru.pish.outadapter.models.dto.EmployeesDTO;
import ru.pish.outadapter.services.SoapEmployeeService;

@Component
public class SoapMapper implements Processor {

    @Autowired
    private SoapEmployeeService soapEmployeeService;

    @Override
    public void process(Exchange exchange) throws Exception {
        Employees body = exchange.getIn().getBody(Employees.class);
        soapEmployeeService.writeEmployee(body);
    }

}
