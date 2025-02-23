package com.zhn.personalproject.baseproject.concreteHandler;

// 客户端代码，构建责任链并发送请求
public class ChainOfResponsibilityDemo {  
    public static void main(String[] args) {  
        Handler<String> handlerA = new ConcreteHandlerA();  
        Handler<String> handlerB = new ConcreteHandlerB();  
  
        // 构建责任链  
        handlerA.setNextHandler(handlerB);  
  
        // 发送请求  
        handlerA.handleRequest("A"); // ConcreteHandlerA 处理请求: A  
        handlerA.handleRequest("B"); // ConcreteHandlerB 处理请求: B  
        handlerA.handleRequest("C"); // 请求未被处理（因为没有处理"C"的处理者）  
    }  
}