package com.ambow.dao;

import com.ambow.bean.BigInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BigDao {
    public void addBig(BigInfo bigInfo);
    public void updateBig(BigInfo bigInfo);
    public void delBig(int id);
    public BigInfo byIdBig(int id);
    public BigInfo selectByNameAndPwd(@Param("uname") String uname, @Param("upwd") String upwd);
    public List<BigInfo> allBig();

    List<BigInfo> getAllBigPage(@Param("page") int page, @Param("yetiao") int yetiao);

    BigInfo selectNameAndType(BigInfo bigInfo);
}
