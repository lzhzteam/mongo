package com.achd.mongo.Entity.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MyocardialInfarction {
    private Integer existence;
    private String time;

    public MyocardialInfarction() {
    }

    public MyocardialInfarction(Integer existence, String time) {
        this.existence = existence;
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyocardialInfarction{" +
                "existence=" + existence +
                ", time='" + time + '\'' +
                '}';
    }

    public Integer getExistence() {
        return existence;
    }

    public void setExistence(Integer existence) {
        this.existence = existence;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
