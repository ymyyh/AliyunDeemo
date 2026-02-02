package com.zhn.personalproject.baseproject.testUtil;

import com.zhn.personalproject.baseproject.unittTestUtil.User;
import com.zhn.personalproject.baseproject.unittTestUtil.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Service 层集成测试
@SpringBootTest( // JUnit 5: Spring Boot 2.1+ 推荐使用 @SpringBootTest
    properties = {
        "spring.main.web-application-type=none"
    }
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // JUnit 5: 替代 JUnit 4 的 @TestInstance(Lifecycle.PER_CLASS)
@DisplayName("UserService Integration Tests")
@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class) // JUnit 5: Mockito 扩展
class UserServiceIntegrationTest {

    // 因为使用的是@SpringBootTest（集成测试），可以直接注入 Spring 管理的 Bean
    @Qualifier("userServiceForTest")
    @Autowired
    private UserService userService;

    @Mock
    private UserService mockUserService;
    
    @BeforeAll
    void setupAll() {
        // JUnit 5: 替代 JUnit 4 的 @BeforeClass
        System.out.println("Setting up UserService integration tests");
    }
    
    @AfterAll
    void tearDownAll() {
        // JUnit 5: 替代 JUnit 4 的 @AfterClass
        System.out.println("Tearing down UserService integration tests");
    }
    
    @Nested // JUnit 5: 嵌套测试类，更好的组织结构
    @DisplayName("用户更新测试")
    class UserUpdateTests {

        
        @Test
        @DisplayName("应该更新用户信息")
        void updateUser_ShouldModifyUserInfo() {
            // Given
            boolean adminPermission = userService.hasPermission(new User("admin"), "write&read");

            when(mockUserService.hasPermission(any(User.class), any(String.class))).thenReturn(true);
            boolean mockAdminPermission = mockUserService.hasPermission(new User("admin"), "write&read");
            // Then
            // 注意：只有mock对象的方法调用才会被记录和验证，非mock对象（userService）的方法不能使用 verify 方法
            verify(mockUserService, times(1)).hasPermission(any(User.class), any(String.class));
            assertThat(adminPermission).isTrue();
        }

    }
}