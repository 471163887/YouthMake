package com.example.fury.youthmake.model;

/**
 * Copyright (C) 年少才华
 * Date: 2015-10-05  00:03
 * Mail: 18844195756@163.com
 * Auth: flt
 */
public class SingleTask {

    private boolean morning_finish; //早上任务完成标记
    private boolean noon_finish;    //下午任务完成标记
    private boolean night_finish;   //晚上任务完成标记

    private boolean complish_tag;   //所有任务完成标记

    private String morning_des;     //早上任务描述
    private String noon_des;        //下午任务描述
    private String night_des;       //晚上任务描述

    public SingleTask(){

    }

    public boolean isComplish_tag() {
        return complish_tag;
    }

    public void setComplish_tag(boolean complish_tag) {
        this.complish_tag = complish_tag;
    }

    public String getMorning_des() {
        return morning_des;
    }

    public void setMorning_des(String morning_des) {
        this.morning_des = morning_des;
    }

    public boolean isMorning_finish() {
        return morning_finish;
    }

    public void setMorning_finish(boolean morning_finish) {
        this.morning_finish = morning_finish;
    }

    public String getNight_des() {
        return night_des;
    }

    public void setNight_des(String night_des) {
        this.night_des = night_des;
    }

    public boolean isNight_finish() {
        return night_finish;
    }

    public void setNight_finish(boolean night_finish) {
        this.night_finish = night_finish;
    }

    public String getNoon_des() {
        return noon_des;
    }

    public void setNoon_des(String noon_des) {
        this.noon_des = noon_des;
    }

    public boolean isNoon_finish() {
        return noon_finish;
    }

    public void setNoon_finish(boolean noon_finish) {
        this.noon_finish = noon_finish;
    }
}
