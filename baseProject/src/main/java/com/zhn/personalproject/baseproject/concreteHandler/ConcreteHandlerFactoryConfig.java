package com.zhn.personalproject.baseproject.concreteHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConcreteHandlerFactoryConfig {
    @Bean
    public ConcreteHandlerFactory buildConcreteHandlerFactory(List<Handler<String>> handlerList){
        return new ConcreteHandlerFactory(handlerList);
    }
}
