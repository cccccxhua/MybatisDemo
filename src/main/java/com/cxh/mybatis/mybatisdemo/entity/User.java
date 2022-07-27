package com.cxh.mybatis.mybatisdemo.entity;

import com.cxh.mybatis.mybatisdemo.enums.UserScore;

public class User {
    private int id;
    private String username;
    private String password;
    private UserScore score;
    private int status;//0是正常，1是删除

    public User() {
    }

    public User(int id, String username, String password, UserScore score, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.score = score;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserScore getScore() {
        return score;
    }

    public void setScore(UserScore score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", status=" + status +
                '}';
    }
}
