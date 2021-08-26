package com.ambow.bean;

public class UserInfo {
    private int uid;
    private String uname;
    private int uflag ; // 1 管理员  0 用户
    private String upwd ;
    private String uimg ;
    private FamllyInfo unum;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUflag() {
        return uflag;
    }

    public void setUflag(int uflag) {
        this.uflag = uflag;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public FamllyInfo getUnum() {
        return unum;
    }

    public void setUnum(FamllyInfo unum) {
        this.unum = unum;
    }

    public UserInfo(int uid, String uname, int uflag, String upwd, String uimg, FamllyInfo unum) {
        this.uid = uid;
        this.uname = uname;
        this.uflag = uflag;
        this.upwd = upwd;
        this.uimg = uimg;
        this.unum = unum;
    }

    public UserInfo() {
    }
}
