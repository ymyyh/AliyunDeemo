package com.zhn.personalproject.baseproject;

import com.zhn.personalproject.baseproject.controller.MyController;
import com.zhn.personalproject.baseproject.dal.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BaseProjectApplicationTests {

	@Autowired
	TestClass testClass;
	@Autowired
	MyController myController;
	@Test
	void contextLoads() {
		List<User> users = myController.getUsers();
		System.out.println(users);
	}

}
