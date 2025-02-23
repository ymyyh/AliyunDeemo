package com.zhn.personalproject.baseproject.exceptionHandler;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;

@Component
public class ExceptionHandler {
    public String handler(Exception e){
        if(e instanceof RuntimeException){
            return "it's runtime exception" + ExceptionEnum.RUNTIME_EXCEPTION.value;
        }
        else if(e instanceof IOException){
            return "it's io exception" + ExceptionEnum.IO_EXCEPTION.value;
        }
        else if(e instanceof SQLException){
            return "it's sql exception" + ExceptionEnum.SQL_EXCEPTION.value;
        }
        else if(e instanceof ClassNotFoundException){
            return "it's class not found exception" + ExceptionEnum.CLASS_NOT_FOUND_EXCEPTION.value;
        }
        return "it's unknown type exception";
    }
}
