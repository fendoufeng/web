package com.example.web.service.serviceImpl;

import com.example.web.entity.User;
import com.example.web.mapper.UserMapper;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        // 用户检测
        if(userMapper.getUserByUsername(user.getUsername()) != null){
            return;
        }

        // 对密码进行Md5加密
        if (user.getPassword() != null){
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            userMapper.addUser(user);
        }


    }

    @Override
    public int editUser(User user) {
       return userMapper.editUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public boolean logIn(String username, String passpord) {
        boolean result = false;

        // 获取用户信息
        User user = userMapper.getUserByUsername(username);

        if (user == null) {
            return  result;
        }

        // 判断密码是否正确
        if (user.getPassword().equals(DigestUtils.md5DigestAsHex(passpord.getBytes()))){
            result = true;
        }

        return result;
    }

    @Override
    public boolean logOut() {
        return true;
    }

    @Override
    public boolean updatePassword(String username, String oldPossword1,String oldPossword2, String newPassword) {
        boolean result = false;

        // 判断旧密码准确度
        if (!oldPossword1.equals(oldPossword2)){
            return  result;
        }

        // 获取用户
        User user = userMapper.getUserByUsername(username);

        // 判断用户是否存在
        if (user == null){
            return result;
        }

        if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(oldPossword1.getBytes()))){
            return  result;
        }

        user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
        user.setUpdate_time(new Date(System.currentTimeMillis()));

        int updateResult = userMapper.editUser(user);

        if (updateResult > 0){
            result = true;
        }

        return result;
    }

    @Override
    public boolean updatePersonalInfo(User user) {
        // 用户检测
        if (userMapper.getUserById(user.getId()) == null){
            return false;
        }

        // 清除用户和密码被覆盖的风险
        user.setUpdate_time(new Date(System.currentTimeMillis()));

        userMapper.editUser(user);
        return true;

    }


}
