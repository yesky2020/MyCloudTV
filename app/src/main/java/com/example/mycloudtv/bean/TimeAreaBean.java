package com.example.mycloudtv.bean;

import java.util.List;
import java.util.Map;

public class TimeAreaBean {

    private int current_process_count;
    private int current_process_count_total;
    private int color_type;
    private int target_type;
    private float factor;
    private int reach_factor;
    private int qualified_factor;

    public int getCurrent_process_count() {
        return current_process_count;
    }

    public void setCurrent_process_count(int current_process_count) {
        this.current_process_count = current_process_count;
    }

    public int getCurrent_process_count_total() {
        return current_process_count_total;
    }

    public void setCurrent_process_count_total(int current_process_count_total) {
        this.current_process_count_total = current_process_count_total;
    }

    public int getColor_type() {
        return color_type;
    }

    public void setColor_type(int color_type) {
        this.color_type = color_type;
    }

    public int getTarget_type() {
        return target_type;
    }

    public void setTarget_type(int target_type) {
        this.target_type = target_type;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public int getReach_factor() {
        return reach_factor;
    }

    public void setReach_factor(int reach_factor) {
        this.reach_factor = reach_factor;
    }

    public int getQualified_factor() {
        return qualified_factor;
    }

    public void setQualified_factor(int qualified_factor) {
        this.qualified_factor = qualified_factor;
    }

}
