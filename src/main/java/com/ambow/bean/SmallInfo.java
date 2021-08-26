package com.ambow.bean;

public class SmallInfo {
    private int sid;
    private String sname;
    private BigInfo bsid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public BigInfo getBsid() {
        return bsid;
    }

    public void setBsid(BigInfo bsid) {
        this.bsid = bsid;
    }

    public SmallInfo(int sid, String sname, BigInfo bsid) {
        this.sid = sid;
        this.sname = sname;
        this.bsid = bsid;
    }

    public SmallInfo() {
    }
}
