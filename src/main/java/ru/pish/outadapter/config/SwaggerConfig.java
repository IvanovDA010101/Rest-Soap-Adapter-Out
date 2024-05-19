package ru.pish.outadapter.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.pish.outadapter.camel.processor.WriteDataIntoDbProcessor;

@Configuration
public class SwaggerConfig {

    @Bean
    @Scope("prototype")
    public WriteDataIntoDbProcessor writeDataIntoDbProcessor() {
        return new WriteDataIntoDbProcessor();
    }

}