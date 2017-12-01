package com.xiaozl.initialwork1.service;

import org.apache.ibatis.annotations.Param;

import com.xiaozl.initialwork1.entity.User;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public interface UserService {

    public User newUser(@Param("user") User user) throws Exception;

    public boolean checkLogin(User user) throws Exception;
}
