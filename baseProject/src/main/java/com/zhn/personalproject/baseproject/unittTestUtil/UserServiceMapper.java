package com.zhn.personalproject.baseproject.unittTestUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userServiceMapperForTest" )
public class UserServiceMapper {
    @Qualifier("userServiceForTest")
    @Autowired
    UserService userService;

    public UserServiceMapper(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
