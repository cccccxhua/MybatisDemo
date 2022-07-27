package com.cxh.mybatis.mybatisdemo.service;


import com.cxh.mybatis.mybatisdemo.dao.UserMapper;
import com.cxh.mybatis.mybatisdemo.entity.User;
import com.cxh.mybatis.mybatisdemo.enums.UserScore;
import com.cxh.mybatis.mybatisdemo.utils.ImportExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User findUserById(int id){
        return userMapper.selectById(id);
    }

    public User findUserByName(String username){
        return userMapper.selectByUsername(username);
    }

    public int updatePassword(int id, String password){
        return userMapper.updatePassword(id, password);
    }

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public List<User> findUsers(){
        return userMapper.selectUsers();
    }

    public int updateStatus(int id,int Status){
        return userMapper.updateStatus(id,Status);
    }

    public List<User> findUsersList(UserScore score){
        return userMapper.selectUsersList(score);
    }

    public int addUsers(String fileName, InputStream is) {
        try {
            List<User> userList = ImportExcelUtils.upload(fileName, is);
            return userMapper.addUsers(userList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
