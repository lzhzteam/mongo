package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Exercise extends TableBase {
    private Integer 频率;
    private Integer 时常;

    public Exercise() {
    }

    public Exercise(Integer 频率, Integer 时常) {
        this.频率 = 频率;
        this.时常 = 时常;
    }

    public Integer get频率() {
        return 频率;
    }

    public void set频率(Integer 频率) {
        this.频率 = 频率;
    }

    public Integer get时常() {
        return 时常;
    }

    public void set时常(Integer 时常) {
        this.时常 = 时常;
    }
}
