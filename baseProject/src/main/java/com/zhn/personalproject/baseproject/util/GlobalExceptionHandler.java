package com.zhn.personalproject.baseproject.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logging = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(IOException.class)
    public void IOExceptionHandler(){
        logging.error("这是一个IO异常");
    }

    @ExceptionHandler(ArithmeticException.class)
    public void ArithmeticExceptionHandler(){
        logging.error("这是一个除零异常");
    }
}
