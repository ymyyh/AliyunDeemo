package com.zhn.personalproject.baseproject.testUtil;

public class UserService {
    public boolean hasPermission(User user, String permission) {
        if("admin".equalsIgnoreCase(user.getRole())){
            return "write&read".equalsIgnoreCase(permission);
        }else if("user".equalsIgnoreCase(user.getRole())){
            return "write".equalsIgnoreCase(permission);
        }else{
            return "read".equalsIgnoreCase(permission);
        }
    }
}
