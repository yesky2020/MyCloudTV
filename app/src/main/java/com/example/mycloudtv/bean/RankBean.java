package com.example.mycloudtv.bean;

public class RankBean {
    private int rank;      //排行
    private String name;   //员工姓名
    private String failTimes;   //失败数
    private String passTimes;   //及格数
    private String doneTimes;   //达成数
    private String points;   //得分

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(String failTimes) {
        this.failTimes = failTimes;
    }

    public String getPassTimes() {
        return passTimes;
    }

    public void setPassTimes(String passTimes) {
        this.passTimes = passTimes;
    }

    public String getDoneTimes() {
        return doneTimes;
    }

    public void setDoneTimes(String doneTimes) {
        this.doneTimes = doneTimes;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
