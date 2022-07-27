package com.cxh.mybatis.mybatisdemo.service;


import com.cxh.mybatis.mybatisdemo.dao.UserMapper;
import com.cxh.mybatis.mybatisdemo.entity.User;
import com.cxh.mybatis.mybatisdemo.enums.UserScore;
import com.cxh.mybatis.mybatisdemo.utils.ImportExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
/**
 * @author CXH
 * @description
 * @create 2022-07-25 14:04
 */
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

    public List<User> findUsersList(String username, UserScore score){

        return userMapper.selectUsersList(username,score);
    }

    public int addUsers(String fileName, InputStream is) {
        try {
            List<User> userList = ImportExcelUtils.upload(fileName, is);
            int count=0;
            for (int i=0;i<userList.size();i++){
                userMapper.addUsers(userList.get(i));
                count++;
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
