package com.xiaozl.initialwork1.service;

import org.apache.ibatis.annotations.Param;

import com.xiaozl.initialwork1.entity.User;

import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public interface UserService {

    public User newUser(@Param("user") User user) throws Exception;

    public boolean checkLogin(User user) throws Exception;

    int update(@Param("user")User user) throws Exception;
    boolean delete(int id) throws Exception;
    User findUserById(int id) throws Exception;
    List<User> findAll() throws Exception;


}
