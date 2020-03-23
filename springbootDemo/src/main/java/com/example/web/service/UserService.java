package com.example.web.service;

import com.example.web.entity.User;

import java.util.List;

public interface  UserService {

    List<User> findAll();

    User getUserById(int id);

    User getUserByUsername(String username);

    void addUser(User user);

    int editUser(User user);

    int deleteUser(int id);

    /**
     * 登录认证
     * @param username 用户名
     * @param password 密码
     * @return 修改成功与否
     */
    boolean logIn(String username,String password);

    /**
     * 退出登录
     * @return boolean
     */
    boolean logOut();

    /**
     * 修改密码
     * @param username 用户名
     * @param oldPossword1 旧密码
     * @param oldPossword2 旧密码（重复）
     * @param newPassword 新密码
     * @return
     */
    boolean updatePassword(String username,String oldPossword1, String oldPossword2, String newPassword);

    boolean updatePersonalInfo(User user);

}
