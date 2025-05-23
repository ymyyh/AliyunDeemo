package com.zhn.personalproject.baseproject.controller;

import com.zhn.personalproject.baseproject.annotation.InterceptorAnnotation;
import com.zhn.personalproject.baseproject.annotation.MyAnnotation;
import com.zhn.personalproject.baseproject.concreteHandler.ConcreteHandlerFactory;
import com.zhn.personalproject.baseproject.dal.entity.User;
import com.zhn.personalproject.baseproject.dal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@InterceptorAnnotation
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    ConcreteHandlerFactory concreteHandlerFactory;

    @GetMapping("/hello")
    @MyAnnotation(value = "world")
    public String hello(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        logger.info("Hello, logging!");
        concreteHandlerFactory.execute("A");
        return "Hello, logging!";
    }

    @GetMapping("/test")
    public String test(@RequestParam("param1") String param1, @RequestParam("param2") String param2) throws SQLException {
        logger.info("Hello, logging!");
        throw new SQLException();
    }

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

}