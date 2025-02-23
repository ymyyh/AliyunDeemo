package com.zhn.personalproject.baseproject.config;

import com.zhn.personalproject.baseproject.annotation.InterceptorAnnotation;
import com.zhn.personalproject.baseproject.exceptionHandler.ExceptionHandler;
import com.zhn.personalproject.baseproject.interceptor.ExceptionInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionInterceptorConfig {
    @Bean
    public DefaultPointcutAdvisor getDefaultPointcutAdvisor(@Autowired ExceptionHandler exceptionHandler){
        ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor(exceptionHandler);
        return new DefaultPointcutAdvisor(new AnnotationMatchingPointcut(InterceptorAnnotation.class,true), exceptionInterceptor);
    }
}
