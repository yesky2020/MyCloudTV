package com.example.mycloudtv.bean;

import java.util.Map;

public class TargetBean {

    private String device_no;
    private String user_name;
    private String program_name;
    private int target_num;
    private String device_serial_num;
    private Map<String, TimeAreaBean> time_area;

    public String getDevice_no() {
        return device_no;
    }

    public void setDevice_no(String device_no) {
        this.device_no = device_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public int getTarget_num() {
        return target_num;
    }

    public void setTarget_num(int target_num) {
        this.target_num = target_num;
    }

    public String getDevice_serial_num() {
        return device_serial_num;
    }

    public void setDevice_serial_num(String device_serial_num) {
        this.device_serial_num = device_serial_num;
    }

    public Map<String, TimeAreaBean> getTime_area() {
        return time_area;
    }

    public void setTime_area(Map<String, TimeAreaBean> time_area) {
        this.time_area = time_area;
    }
}
