package com.example.mycloudtv.bean;

public class VersionBean {
    public String status;
    public String code;
    public String message;
    public DataBean data;
    public String duration;
    public String errorCode;


    public static class DataBean {
        public String id;
        public String dictionary_pid;
        public String dictionary_name;
        public String dictionary_name_cn;
        public String order_id;
        public String app_id;
        public String create_time;
        public String create_by;
        public String last_time;
        public String modify_by;
        public String dictionary_value;
    }
}
