package com.zhn.personalproject.baseproject.concreteHandler;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 具体处理者A，处理特定类型的请求（例如：String类型的"A"）
@Component
@Order(1)
class ConcreteHandlerA implements Handler<String> {  
    private Handler<String> nextHandler;  
  
    @Override  
    public void handleRequest(String request) {  
        if ("A".equals(request)) {  
            System.out.println("ConcreteHandlerA 处理请求: " + request);  
        } else {  
            if (nextHandler != null) {  
                nextHandler.handleRequest(request);  
            }  
        }  
    }  
  
    @Override  
    public void setNextHandler(Handler<String> nextHandler) {  
        this.nextHandler = nextHandler;  
    }  
}