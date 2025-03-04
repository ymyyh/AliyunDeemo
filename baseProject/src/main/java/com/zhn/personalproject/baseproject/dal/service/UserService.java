package com.zhn.personalproject.baseproject.dal.service;

import com.zhn.personalproject.baseproject.dal.entity.User;
import com.zhn.personalproject.baseproject.dal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.selectList(null);  // 查询所有用户
    }

    public User getUserById(String guid) {
        return userMapper.selectById(guid);  // 根据 ID 查询用户
    }

    public int insertUser(User user) {
        return userMapper.insert(user);  // 插入用户
    }

    public int updateUser(User user) {
        return userMapper.updateById(user);  // 更新用户
    }

    public int deleteUser(String guid) {
        return userMapper.deleteById(guid);  // 删除用户
    }
}