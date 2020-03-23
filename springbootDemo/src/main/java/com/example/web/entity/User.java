package com.example.web.entity;

import java.util.Date;


public class User {
    // 唯一id
    private int id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 手机号码
    private String phonenumber;
    // 昵称
    private String nickname;
    // 电子邮箱
    private String email;
    //出生日期
    private Date brithday;
    // 用户状态
    private int user_status;
    // 创建时间
    private Date create_time;
    // 修改时间
    private Date update_time;
    // 最后的登录时间
    private Date last_log_time;

    public User(){}

    public User(int id, String username, String password,String phonenumber,String nickname,String email,Date brithday,int user_status,Date create_time,Date update_time,Date last_log_time){
        this.id = id;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.nickname = nickname;
        this.email = email;
        this.brithday = brithday;
        this.user_status = user_status;
        this.create_time = create_time;
        this.update_time =update_time;
        this.last_log_time = last_log_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getLast_log_time() {
        return last_log_time;
    }

    public void setLast_log_time(Date last_log_time) {
        this.last_log_time = last_log_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", brithday=" + brithday +
                ", user_status=" + user_status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", last_log_time=" + last_log_time +
                '}';
    }
}
