package com.xiaozl.initialwork1.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.mapper.UserMapper;
import com.xiaozl.initialwork1.service.UserService;

import java.util.Collections;
import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User newUser(@Param("user") User user) throws Exception {
        if (user == null || "".equals(user.getPassword())||"".equals(user.getUserName())) {
            return null;
        }

        try {
            user.setPassword(user.getPassword());
            userMapper.newUser(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return user;
    }

    public boolean checkLogin(User user) throws Exception {
        if (user == null) {
            return false;
        }

        try {
            return userMapper.countByUserNameAndPassword(user.getUserName(), user.getPassword()) > 0 ? true : false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 根据  id  删除 数据
     */
    public boolean deleteUserById(int id) {
        try {
            userMapper.deleteUserById(id);
        }catch (Exception e){

        }
        return  false;
    }

    /**
     * 查询User的全部数据
     */
    public List<User> findAll() {
        List<User> findAllList = Collections.emptyList();
        try {
            findAllList = userMapper.findAll();
        }
        catch (Exception e ){
        }
        return findAllList;
    }
    /**
     * 根据 id 查询 对应数据
     */
    public User findUserById(int id) throws Exception {
        User user =userMapper.findUserById(id);
        return user;
    }
    /**
     * 新增数据
     */
    public void insertUser(User user) {
        try {
            userMapper.insertUser(user.getUserName(),user.getPassword()  )   ;
        }catch (Exception e){
        }

    }
    /**
     * 根据 id 修改对应数据
     */
    public int update(User user) {
        try{
            return userMapper.updateUserById(user);
        }catch (Exception e){
            return 0;
        }
    }

   @Override
   public boolean delete(int id) throws Exception{
        try {
userMapper.deleteUserById(id);
        }catch (Exception e){

        }
        return false;
   }
}
