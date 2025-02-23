package com.zhn.personalproject.baseproject.concreteHandler;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;

public class ConcreteHandlerFactory<T> {
    Handler<T> firstNode;
    public ConcreteHandlerFactory(List<Handler<T>> handlerList) {
        for(int i = 0;i < handlerList.size(); ++i){
            if(i != handlerList.size() - 1){
                handlerList.get(i).setNextHandler(handlerList.get(i + 1));
            }
        }
        if(!CollectionUtils.isEmpty(handlerList)) {
            firstNode = handlerList.get(0);
        }
    }

    public void execute(T input){
        if(!ObjectUtils.isEmpty(firstNode)){
            firstNode.handleRequest(input);
        }
    }
}
