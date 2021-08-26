package com.ambow.dao;

import com.ambow.bean.FamllyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FamllyDao {
    public void addFamlly(FamllyInfo famllyInfo);
    public void updateFamlly(FamllyInfo famllyInfo);
    public void delFamlly(int id);
    public FamllyInfo byIdFamlly(int id);
    public FamllyInfo selectByNameAndPwd(@Param("fid") int a, @Param("fpwd") String b);
    public List<FamllyInfo> allFamlly();

    FamllyInfo selectIsName(@Param("fname") String fname);

    public void upPwd(@Param("fid")int fid,@Param("fpwd")String fpwd);
}
