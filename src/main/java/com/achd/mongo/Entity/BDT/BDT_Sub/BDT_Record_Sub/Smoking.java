package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Smoking extends TableBase {
    private Integer 频率;
    private Integer 经常吸支数;
    private Integer 经常吸年;
    private Integer 过去吸年;
    private Integer 过去吸月;

    public Smoking() {
    }

    public Smoking(Integer 频率, Integer 经常吸支数, Integer 经常吸年, Integer 过去吸年, Integer 过去吸月) {
        this.频率 = 频率;
        this.经常吸支数 = 经常吸支数;
        this.经常吸年 = 经常吸年;
        this.过去吸年 = 过去吸年;
        this.过去吸月 = 过去吸月;
    }

    public Integer get频率() {
        return 频率;
    }

    public void set频率(Integer 频率) {
        this.频率 = 频率;
    }

    public Integer get经常吸支数() {
        return 经常吸支数;
    }

    public void set经常吸支数(Integer 经常吸支数) {
        this.经常吸支数 = 经常吸支数;
    }

    public Integer get经常吸年() {
        return 经常吸年;
    }

    public void set经常吸年(Integer 经常吸年) {
        this.经常吸年 = 经常吸年;
    }

    public Integer get过去吸年() {
        return 过去吸年;
    }

    public void set过去吸年(Integer 过去吸年) {
        this.过去吸年 = 过去吸年;
    }

    public Integer get过去吸月() {
        return 过去吸月;
    }

    public void set过去吸月(Integer 过去吸月) {
        this.过去吸月 = 过去吸月;
    }


    public Integer gtFrequency() {
        return 频率;
    }

    public void stFrequency(Integer 频率) {
        this.频率 = 频率;
    }

    public Integer gtNumber() {
        return 经常吸支数;
    }

    public void stNumber(Integer 经常吸支数) {
        this.经常吸支数 = 经常吸支数;
    }

    public Integer gtYear() {
        return 经常吸年;
    }

    public void stYear(Integer 经常吸年) {
        this.经常吸年 = 经常吸年;
    }

    public Integer gtPastYear() {
        return 过去吸年;
    }

    public void stPastYear(Integer 过去吸年) {
        this.过去吸年 = 过去吸年;
    }

    public Integer gtPastMonth() {
        return 过去吸月;
    }

    public void stPastMonth(Integer 过去吸月) {
        this.过去吸月 = 过去吸月;
    }



}
