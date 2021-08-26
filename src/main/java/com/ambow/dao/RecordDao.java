package com.ambow.dao;

import com.ambow.bean.RecordInfo;
import com.ambow.bean.SmallInfo;
import com.ambow.bean.UserInfo;
import com.sun.prism.impl.Disposer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordDao {
    public void addRecord(RecordInfo recordInfo);
    public void updateRecord(RecordInfo recordInfo);
    public void delRecord(int id);
    public RecordInfo byIdRecord(int id);
    public RecordInfo selectByNameAndPwd(@Param("uname") String uname, @Param("upwd") String upwd);
    public List<RecordInfo> allRecord();
    List<RecordInfo> getAllRecord(@Param("page") int page, @Param("yetiao") int yetiao);
    List<RecordInfo> getAllRecordPage(@Param("number") int number,@Param("page") int page, @Param("yetiao") int yetiao);

    List<RecordInfo> byTime(@Param("ud")int number,@Param("time")String a, @Param("tim")String b,@Param("flag")int flag);

    List<RecordInfo> byUnumRecord(UserInfo userInfo);

}
