package ru.pish.outadapter.config;


import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import ru.pish.outadapter.camel.processor.WriteDataIntoDbProcessor;

import java.time.Duration;

@Configuration
public class SwaggerConfig {

    @Bean
    @Scope("prototype")
    public WriteDataIntoDbProcessor writeDataIntoDbProcessor() {
        return new WriteDataIntoDbProcessor();
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration("employeeCache",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
    }
}