package com.mexbo.service.impl;

import com.mexbo.pojo.Users;
import com.mexbo.service.UserService;
import com.mexbo.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Test
    public void queryUsernameIsExist() {
        boolean usernameIsExist = userService.queryUsernameIsExist("33");
        if (usernameIsExist) {
            System.err.println("Found");
        }else{
            System.err.println("Not Found");
        }
    }

    @Test
    public void queryUserForLogin() throws Exception {
        boolean usernameIsExist = userService.queryUsernameIsExist("33");
        Users userResult = null;
        if (usernameIsExist) {
            // 1.1 登录
            userResult = userService.queryUserForLogin("33", MD5Utils.getMD5Str("33"));
            if (userResult == null) {
                System.err.println("用户名或密码不正确...");
            }else{
                System.err.println("用户名密码正确");
            }
        }else{
            System.err.println("用户不存在");
        }
    }

    @Test
    public void saveUser() throws Exception {
        Users user=new Users();
        user.setUsername("33");
        user.setPassword(MD5Utils.getMD5Str("33"));
        user.setNickname(user.getUsername());
        user.setFaceImage("");
        user.setFaceImageBig("");
        userService.saveUser(user);
    }

    @Test
    public void updateUserInfo() {
    }

    @Test
    public void queryUserById() {
    }
}