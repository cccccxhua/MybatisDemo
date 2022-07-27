package com.cxh.mybatis.mybatisdemo.dao;

import com.cxh.mybatis.mybatisdemo.entity.User;
import com.cxh.mybatis.mybatisdemo.enums.UserScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author CXH
 * @description
 * @create 2022-07-25 14:02
 */
@Mapper
public interface UserMapper {
    public abstract User selectById(int id);//通过id查询用户
    public abstract List<User> selectUsers();//通过id查询用户
    public abstract User selectByUsername(String username);//通过username查询用户
    public abstract int insertUser(User user);//添加用户
    public abstract int updatePassword(int id,String password);//修改用户密码
    public abstract int updateStatus(int id,int status);//删除用户
    public abstract List<User> selectUsersList(String username, UserScore score);//统计等级

    // 批量添加用户数据
   // public abstract int addUsers(List<User> users);
    public abstract int addUsers(User user);
}
