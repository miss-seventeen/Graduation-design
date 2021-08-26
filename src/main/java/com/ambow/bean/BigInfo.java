package com.ambow.bean;

public class BigInfo {
    private int bid;//大类编号
    private String bname;//大类名称
    private String btype;//大类类型 0收入 或者1支出

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public BigInfo(int bid, String bname, String btype) {
        this.bid = bid;
        this.bname = bname;
        this.btype = btype;
    }

    public BigInfo() {
    }
}
