package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ACHD{
    private Integer existence;
    @DBRef
    private Who who;

    public ACHD() {
    }

    public ACHD(Integer existence) {
        this.existence = existence;
    }



    @Override
    public String toString() {
        return "ACHD{" +
                "existence=" + existence +
                ", who=" + who +
                '}';
    }

    public Integer getExistence() {
        return existence;
    }

    public void setExistence(Integer existence) {
        this.existence = existence;
    }

    public Who getWho() {
        return who;
    }

    public void setWho(Who who) {
        this.who = who;
    }
}