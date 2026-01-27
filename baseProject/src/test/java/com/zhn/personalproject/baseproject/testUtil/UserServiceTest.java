package com.zhn.personalproject.baseproject.testUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserServiceMapper userServiceMapper;
    
    // 参数化测试示例
    @ParameterizedTest
    @ValueSource(strings = {"admin", "user", "guest"})
    @DisplayName("测试不同角色的用户权限")
    void testUserRoles(String role) {
        // 准备测试数据
        User user = new User(role);

        UserService mapperUserService = userServiceMapper.getUserService();

        when(userService.hasPermission(user, "write")).thenReturn(false);
        
        // 执行业务逻辑
        boolean hasPermission = mapperUserService.hasPermission(user, "write");
        
        // 断言验证
        assertTrue(hasPermission, "这些角色的权限不是写权限: " + role);
    }
}