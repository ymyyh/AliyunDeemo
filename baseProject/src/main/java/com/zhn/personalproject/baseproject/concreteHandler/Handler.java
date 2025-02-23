package com.zhn.personalproject.baseproject.concreteHandler;

// 抽象处理者接口，使用泛型来定义请求的类型
interface Handler<T> {
    void handleRequest(T request);  
    void setNextHandler(Handler<T> nextHandler);  
}  