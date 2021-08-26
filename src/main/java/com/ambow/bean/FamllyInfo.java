package com.ambow.bean;

public class FamllyInfo {
    private int fid;
    private String fname;
    private String fpwd;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFpwd() {
        return fpwd;
    }

    public void setFpwd(String fpwd) {
        this.fpwd = fpwd;
    }

    public FamllyInfo(int fid, String fname, String fpwd) {
        this.fid = fid;
        this.fname = fname;
        this.fpwd = fpwd;
    }

    public FamllyInfo() {
    }
}
