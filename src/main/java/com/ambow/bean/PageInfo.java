package com.ambow.bean;

public class PageInfo {
    private int dangPage;//当前页
    private int yeTiao;//每页条数
    private int totalPage;//总页数
    private int totalTiao;//总条数
    private int start;//起始位置
    public int getDangPage() {
        return dangPage;
    }
    public void setDangPage(int dangPage) {
        this.dangPage = dangPage;
    }
    public int getYeTiao() {
        return yeTiao;
    }
    public void setYeTiao(int yeTiao) {
        this.yeTiao = yeTiao;
    }
    public int getTotalPage() {
        return (totalTiao%yeTiao==0)?totalTiao/yeTiao:totalTiao/yeTiao+1;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalTiao() {
        return totalTiao;
    }
    public void setTotalTiao(int totalTiao) {
        this.totalTiao = totalTiao;
    }
    public int getStart() {
        return (dangPage-1)*yeTiao;
    }

}
