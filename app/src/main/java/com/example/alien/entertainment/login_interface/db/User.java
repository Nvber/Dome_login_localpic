package com.example.alien.entertainment.login_interface.db;

/**
 * Created by Administrator on 2016/8/16.
 */
public class User {
//    用户名
    private String username;
//    密码
    private String userpwd;

    public User(String username, String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                '}';
    }
}
