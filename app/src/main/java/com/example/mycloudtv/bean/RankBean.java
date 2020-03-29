package com.example.mycloudtv.bean;

import java.util.List;

public class RankBean {
    private int status;
    private String code;
    private String message;
    private int duration;
    private String errorCode;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String schedul_rank_id;
        private String company;
        private String factory_name;
        private String workshop;
        private String schedule_name;
        private long current_time;
        private long create_time;
        private int schedule_id;
        private String rank_json;
        private Object schedualRankReportInfoList;

        public String getSchedul_rank_id() {
            return schedul_rank_id;
        }

        public void setSchedul_rank_id(String schedul_rank_id) {
            this.schedul_rank_id = schedul_rank_id;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getFactory_name() {
            return factory_name;
        }

        public void setFactory_name(String factory_name) {
            this.factory_name = factory_name;
        }

        public String getWorkshop() {
            return workshop;
        }

        public void setWorkshop(String workshop) {
            this.workshop = workshop;
        }

        public String getSchedule_name() {
            return schedule_name;
        }

        public void setSchedule_name(String schedule_name) {
            this.schedule_name = schedule_name;
        }

        public long getCurrent_time() {
            return current_time;
        }

        public void setCurrent_time(long current_time) {
            this.current_time = current_time;
        }

        public long getCreate_time() {
            return create_time;
        }

        public void setCreate_time(long create_time) {
            this.create_time = create_time;
        }

        public int getSchedule_id() {
            return schedule_id;
        }

        public void setSchedule_id(int schedule_id) {
            this.schedule_id = schedule_id;
        }

        public String getRank_json() {
            return rank_json;
        }

        public void setRank_json(String rank_json) {
            this.rank_json = rank_json;
        }

        public Object getSchedualRankReportInfoList() {
            return schedualRankReportInfoList;
        }

        public void setSchedualRankReportInfoList(Object schedualRankReportInfoList) {
            this.schedualRankReportInfoList = schedualRankReportInfoList;
        }

    }
}
