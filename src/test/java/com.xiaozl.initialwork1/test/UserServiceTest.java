package com.xiaozl.initialwork1.test;

import com.xiaozl.initialwork1.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaozl.initialwork1.AbstractTestCase;
import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.service.UserService;

import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public class UserServiceTest extends AbstractTestCase {
    @Autowired
    private UserService userService;
    UserMapper userMapper;

    @Test
    public void newUser() throws Exception {
        User user = new User();
        user.setUserName("xiaozlhh");
        user.setPassword("12345678");

        userService.newUser(user);

    }

    @Test
    public void test() throws Exception{
        User user=new User();
        user.setUserName("123");
        user.setPassword("123");
        user.setId(11);
        int i=userService.update(user);
    }
}
