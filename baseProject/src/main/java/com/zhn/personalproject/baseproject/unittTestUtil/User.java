package com.zhn.personalproject.baseproject.unittTestUtil;

import org.springframework.stereotype.Component;

public class User {
    String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
