package com.example.mycloudtv.bean;

/**
 * 车间全局状态
 */
public class WorkShopStatusBean {
    private long id;
    private String name;
    /** 状态：0:运行, 1:待机, 2:关机, 3:告警, 4:默认**/
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
