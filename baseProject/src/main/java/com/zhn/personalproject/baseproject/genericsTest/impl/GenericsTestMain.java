package com.zhn.personalproject.baseproject.genericsTest.impl;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class GenericsTestMain<T> {
    public static void main(String[] args) throws NoSuchMethodException {
        String str = null;
        Optional<String> optionalString = Optional.ofNullable(str);
        Integer i = optionalString.map(String::length).orElse(-111);
        System.out.println(i);

        Function getClass = Object::getClass;
    }

    // 泛型数组类型字段
    private T[] genericArray;
}
