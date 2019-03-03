package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Exercise {
    private Integer type;
    private Integer ps;

    public Exercise() {
    }

    public Exercise(Integer type, Integer ps) {
        this.type = type;
        this.ps = ps;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "type=" + type +
                ", ps=" + ps +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }
}
