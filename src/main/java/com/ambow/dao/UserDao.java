package com.ambow.dao;

import com.ambow.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public void addUser(UserInfo user);
    public void updateUser(UserInfo user);
    public void delUser(int id);
    public UserInfo byIdUser(int id);
    public UserInfo selectByNameAndPwd(@Param("uname") String uname,@Param("upwd") String upwd);
    public List<UserInfo> allUser();

    UserInfo selectIsName(@Param("uname") String uname);

    public void upPwd(@Param("uid")int uid,@Param("upwd")String s);
    public List<UserInfo> byFlag(@Param("id")int a);

    List<UserInfo> byName(UserInfo userInfo);

}
