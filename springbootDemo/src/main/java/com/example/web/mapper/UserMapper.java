package com.example.web.mapper;

import com.example.web.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 查询所有用户信息
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 根据ID获取用户信息
     * @param id 用户id
     * @return user对象
     */
    User getUserById(int id);

    /**
     * 根据ID获取用户信息
     * @param username 用户名
     * @return user对象
     */
    User getUserByUsername(String username);

    /**
     * 添加用户信息
     * @param user 用户对象
     */
    void addUser(User user);

    /**
     * 修改用户信息(可修改全部)
     * @param user 用户
     */
    int editUser(User user);

    /**
     * 通过Id删除用户
     * @param id 用户Id
     * @return Int
     */
    int deleteUser(int id);



}
