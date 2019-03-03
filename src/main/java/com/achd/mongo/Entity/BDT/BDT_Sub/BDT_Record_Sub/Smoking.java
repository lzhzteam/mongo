package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Smoking {
    private Integer type;
    private String ps;

    public Smoking() {
    }

    public Smoking(Integer type, String ps) {
        this.type = type;
        this.ps = ps;
    }

    @Override
    public String toString() {
        return "Smoking{" +
                "type=" + type +
                ", ps='" + ps + '\'' +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}
