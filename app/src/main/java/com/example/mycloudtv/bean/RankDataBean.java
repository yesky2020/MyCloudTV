package com.example.mycloudtv.bean;

public class RankDataBean {
    private int failurego_count;  //失败数
    private int order_id;  //排名
    private int qualified_count; //及格数
    private int rank_score;    //得分
    private int reach_count;   //达成数
    private String staff;   //员工

    public int getFailurego_count() {
        return failurego_count;
    }

    public void setFailurego_count(int failurego_count) {
        this.failurego_count = failurego_count;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getQualified_count() {
        return qualified_count;
    }

    public void setQualified_count(int qualified_count) {
        this.qualified_count = qualified_count;
    }

    public int getRank_score() {
        return rank_score;
    }

    public void setRank_score(int rank_score) {
        this.rank_score = rank_score;
    }

    public int getReach_count() {
        return reach_count;
    }

    public void setReach_count(int reach_count) {
        this.reach_count = reach_count;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }
}
