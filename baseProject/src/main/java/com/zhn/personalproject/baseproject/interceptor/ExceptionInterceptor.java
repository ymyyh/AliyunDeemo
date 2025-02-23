package com.zhn.personalproject.baseproject.interceptor;

import com.zhn.personalproject.baseproject.exceptionHandler.ExceptionHandler;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ExceptionInterceptor implements MethodInterceptor {

    ExceptionHandler exceptionHandler;
    public ExceptionInterceptor(ExceptionHandler exceptionHandler){
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try{
            Object result = methodInvocation.proceed();
            return result;
        }
        catch (Exception e){
            System.out.println(exceptionHandler.handler(e));
            return null;
        }finally {
            System.out.println("exception handled!!");
        }
    }
}
