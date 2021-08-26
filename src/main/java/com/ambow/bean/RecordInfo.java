package com.ambow.bean;

public class RecordInfo {
    private int rid;
    private SmallInfo rsid;
    private String rtime;
    private double money;
    private String runame;
    private UserInfo uid;
    private String wtime;
    private String beizhu;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public SmallInfo getRsid() {
        return rsid;
    }

    public void setRsid(SmallInfo rsid) {
        this.rsid = rsid;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getRuname() {
        return runame;
    }

    public void setRuname(String runame) {
        this.runame = runame;
    }

    public UserInfo getUid() {
        return uid;
    }

    public void setUid(UserInfo uid) {
        this.uid = uid;
    }

    public String getWtime() {
        return wtime;
    }

    public void setWtime(String wtime) {
        this.wtime = wtime;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public RecordInfo(int rid, SmallInfo rsid, String rtime, double money, String runame, UserInfo uid, String wtime, String beizhu) {
        this.rid = rid;
        this.rsid = rsid;
        this.rtime = rtime;
        this.money = money;
        this.runame = runame;
        this.uid = uid;
        this.wtime = wtime;
        this.beizhu = beizhu;
    }

    public RecordInfo() {
    }
}
