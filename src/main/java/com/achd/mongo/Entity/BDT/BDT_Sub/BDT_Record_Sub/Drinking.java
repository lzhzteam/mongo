package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Drinking extends TableBase {
    private Integer type;

    @DBRef
    private Ps ps;




    public Drinking() {
    }

    public Drinking(Integer type, Ps ps) {
        this.type = type;
        this.ps = ps;
    }

    @Override
    public String toString() {
        return "Drinking{" +
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

    public Ps getPs() {
        return ps;
    }

    public void setPs(Ps ps) {
        this.ps = ps;
    }
}
