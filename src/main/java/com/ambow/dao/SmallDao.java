package com.ambow.dao;

import com.ambow.bean.SmallInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmallDao {
    public void addSmall(SmallInfo smallInfo);
    public void updateSmall(SmallInfo smallInfo);
    public void delSmall(int id);
    public SmallInfo byIdSmall(int id);
    public SmallInfo selectByNameAndPwd(@Param("uname") String uname, @Param("upwd") String upwd);
    public List<SmallInfo> allSmall();

    List<SmallInfo> getAllSmallPage(@Param("page") int page, @Param("yetiao") int yetiao);

    List<SmallInfo> getAllSmallByBid(int id);

    SmallInfo selectNameAndType(SmallInfo smallInfo);
}
