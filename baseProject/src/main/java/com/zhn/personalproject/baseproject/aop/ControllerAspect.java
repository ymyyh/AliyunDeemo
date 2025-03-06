package com.zhn.personalproject.baseproject.aop;

import com.zhn.personalproject.baseproject.annotation.MyAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class ControllerAspect {
    private static final Logger logging = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("@annotation(com.zhn.personalproject.baseproject.annotation.MyAnnotation)")
    public void pointcut(){
    }

    @Around(value = "execution(* com.zhn.personalproject.baseproject.controller.MyController.*hello*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        logging.info("around切面方法");
        try {
            logging.info(Arrays.stream(joinPoint.getArgs()).map(o -> o.toString()).collect(Collectors.joining(",")));
            Object result = joinPoint.proceed();
            logging.info(String.valueOf(joinPoint.getClass()));
            return result;
        }
        catch (Throwable e){
            logging.error("在切点方法中出现了异常");
        }
        return null;
    }

    @Before(value = "execution(* com.zhn.personalproject.baseproject.controller.MyController.*hello*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        logging.info("before切面方法");
        try {
            logging.info(Arrays.stream(joinPoint.getArgs()).map(o -> o.toString()).collect(Collectors.joining(",")));
            logging.info(String.valueOf(joinPoint.getClass()));
            System.out.println(joinPoint.getSignature().getDeclaringType().getName());
        }
        catch (Throwable e){
            logging.error("在切点方法中出现了异常");
        }
    }

    @After(value = "pointcut()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("hello ");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        MyAnnotation annotation = signature.getMethod().getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());
    }
}




