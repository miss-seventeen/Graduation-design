package com.ambow.service;

import com.ambow.bean.UserInfo;
import com.ambow.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public List<UserInfo> byFlag(){
        System.out.println("查身份");
        int a=1;
       return userDao.byFlag(a);
    }
    public void addUser(UserInfo userInfo){
        userDao.addUser(userInfo);
    }
    public void delUser(int id){
        userDao.delUser(id);
    }
    public void updateUser(UserInfo userInfo){
        userDao.updateUser(userInfo);
    }
    public List<UserInfo> selectAll(){
        return userDao.allUser();
    }
    public UserInfo byIdUser(UserInfo userInfo){
        int id=userInfo.getUid();
        return userDao.byIdUser(id);
    }
    public UserInfo selectByNameAndPwd(UserInfo userInfo){
        System.out.println("service层接到了");
        String a=userInfo.getUname();
        String b=userInfo.getUpwd();
        System.out.println("a="+a+"b="+b);
        return userDao.selectByNameAndPwd(a,b);
    }

    public void forget(UserInfo userInfo) {
        System.out.println("忘记密");
        UserInfo user=userDao.selectIsName(userInfo.getUname());
        if(user!=null){
            userDao.upPwd(user.getUid(),"123456");
            System.out.println("判断");
        }
    }

    public List<UserInfo> byName(UserInfo userInfo) {
        return userDao.byName(userInfo);
    }

}
