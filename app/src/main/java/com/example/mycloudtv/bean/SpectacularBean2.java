package com.example.mycloudtv.bean;

import java.util.List;
import java.util.Map;

public class SpectacularBean2 {
    private int status;
    private String code;
    private Object message;
    private int duration;
    private Object errorCode;
    private List<SpectacularBean2.DataBean> data;

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

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public List<SpectacularBean2.DataBean> getData() {
        return data;
    }

    public void setData(List<SpectacularBean2.DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String schedul_targert_id;
        private String company;
        private String factory_name;
        private String workshop;
        private long current_time;
        private long create_time;
        private int schedule_id;
        private String schedule_name;
        private String schedule_start_time;
        private String schedule_end_time;
        private Map<String, TargetBean> target_statistics_json;

        public String getSchedul_targert_id() {
            return schedul_targert_id;
        }

        public void setSchedul_targert_id(String schedul_targert_id) {
            this.schedul_targert_id = schedul_targert_id;
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

        public String getSchedule_name() {
            return schedule_name;
        }

        public void setSchedule_name(String schedule_name) {
            this.schedule_name = schedule_name;
        }

        public String getSchedule_start_time() {
            return schedule_start_time;
        }

        public void setSchedule_start_time(String schedule_start_time) {
            this.schedule_start_time = schedule_start_time;
        }

        public String getSchedule_end_time() {
            return schedule_end_time;
        }

        public void setSchedule_end_time(String schedule_end_time) {
            this.schedule_end_time = schedule_end_time;
        }

        public Map<String, TargetBean> getTarget_statistics_json() {
            return target_statistics_json;
        }

        public void setTarget_statistics_json(Map<String, TargetBean> target_statistics_json) {
            this.target_statistics_json = target_statistics_json;
        }
    }
}
