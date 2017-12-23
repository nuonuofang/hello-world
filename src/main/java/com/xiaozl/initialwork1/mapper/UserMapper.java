package com.xiaozl.initialwork1.mapper;

import org.apache.ibatis.annotations.Param;

import com.xiaozl.initialwork1.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
@Component
public interface UserMapper {

    public void newUser(@Param("user") User user) throws Exception;

    public int countByUserNameAndPassword(@Param("userName") String userName,
                                          @Param("password") String password) throws Exception;
/**
 * 根据id删除用户
 * @param id
 * @throws Exception
 * */
    void deleteUserById(@Param("id") Integer id) throws Exception;
    /**
     * 增加用户
     * @param  user_name
     * @param  password
     * @throws Exception
     * */
    void insertUser(@Param("user_name") String user_name,
                    @Param("password") String password) throws Exception;
    /**
     * 修改用户
     * @param  user_name
     * @param  password
     * @throws Exception
     * */
    int updateUserById(@Param("user")User user) throws Exception;
    /**
     * 查询用户
     * @param  id
     * @throws Exception
     * */
    User findUserById(@Param("id") Integer id) throws Exception;

/**
 * 查询所有用户
 * @param
 * @throws Exception
 * */
    List<User> findAll()throws Exception;
}
