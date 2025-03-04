package com.zhn.personalproject.baseproject.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_test")
public class User {
    private String guid;
    private String userName;
    private Integer userAge;
}