package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Drinking extends TableBase {
    private Integer 频率;

    //    @DBRef
    private Ps 经常饮;

    private Integer 过去饮年;



    public Drinking() {
    }

    public Drinking(Integer 频率, Ps 经常饮, Integer 过去饮年) {
        this.频率 = 频率;
        this.经常饮 = 经常饮;
        this.过去饮年 = 过去饮年;
    }

    public Integer get频率() {
        return 频率;
    }

    public void set频率(Integer 频率) {
        this.频率 = 频率;
    }

    public Ps get经常饮() {
        return 经常饮;
    }

    public void set经常饮(Ps 经常饮) {
        this.经常饮 = 经常饮;
    }

    public Integer get过去饮年() {
        return 过去饮年;
    }

    public void set过去饮年(Integer 过去饮年) {
        this.过去饮年 = 过去饮年;
    }


    public Integer gtFrequency() {
        return 频率;
    }

    public void stFrequency(Integer 频率) {
        this.频率 = 频率;
    }

    public Ps gtAlways() {
        return 经常饮;
    }

    public void stAlways(Ps 经常饮) {
        this.经常饮 = 经常饮;
    }

    public Integer gtYears() {
        return 过去饮年;
    }

    public void stYears(Integer 过去饮年) {
        this.过去饮年 = 过去饮年;
    }
}
