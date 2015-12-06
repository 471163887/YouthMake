package com.example.fury.youthmake.model;

import android.util.Log;

/**
 * Copyright (C) 年少才华
 * Date: 2015-10-04  23:51
 * Mail: 18844195756@163.com
 * Auth: flt
 */
public class WeekTask {
    private boolean W_finish;
    private int W_ID;
    private int W_taskNum;

    private String W_startTime;
    private String W_endTime;
    private String W_description;

    public WeekTask(){

    }
    //不能用单例，因为以后可能需要保存这些WeekTask对象
    /*private static WeekTask weekTask = null;

    public static WeekTask getInstance() {
        if (weekTask == null) {
            weekTask = new WeekTask();
        }
        return weekTask;
    }*/

    public void print(){

    }

    public String getW_description() {
        return W_description;
    }

    public void setW_description(String w_description) {
        W_description = w_description;
    }

    public String getW_endTime() {
        return W_endTime;
    }

    public void setW_endTime(String w_endTime) {
        W_endTime = w_endTime;
    }

    public boolean isW_finish() {
        return W_finish;
    }

    public void setW_finish(boolean w_finish) {
        W_finish = w_finish;
    }

    public int getW_ID() {
        return W_ID;
    }

    public void setW_ID(int w_ID) {
        W_ID = w_ID;
    }

    public String getW_startTime() {
        return W_startTime;
    }

    public void setW_startTime(String w_startTime) {
        W_startTime = w_startTime;
    }

    public int getW_taskNum() {
        return W_taskNum;
    }

    public void setW_taskNum(int w_taskNum) {
        W_taskNum = w_taskNum;
    }
}
