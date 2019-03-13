package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Exercise extends TableBase {
    private Integer 频率;
    private Integer 时长;

    public Exercise() {
    }

    public Exercise(Integer 频率, Integer 时长) {
        this.频率 = 频率;
        this.时长 = 时长;
    }

    public Integer get频率() {
        return 频率;
    }

    public void set频率(Integer 频率) {
        this.频率 = 频率;
    }

    public Integer get时长() {
        return 时长;
    }

    public void set时长(Integer 时长) {
        this.时长 = 时长;
    }


    public Integer gtFrequency() {
        return 频率;
    }

    public void stFrequency(Integer 频率) {
        this.频率 = 频率;
    }

    public Integer gtDuration() {
        return 时长;
    }

    public void stDuration(Integer 时长) {
        this.时长 = 时长;
    }


}
