package com.achd.mongo.Entity.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PeripheralVascularDisease {
    private Integer existence;
    private String time;
    private String position;
    private Integer type;

    public PeripheralVascularDisease() {
    }

    public PeripheralVascularDisease(Integer existence, String time, String position, Integer type) {
        this.existence = existence;
        this.time = time;
        this.position = position;
        this.type = type;
    }

    @Override
    public String toString() {
        return "PeripheralVascularDisease{" +
                "existence=" + existence +
                ", time='" + time + '\'' +
                ", position='" + position + '\'' +
                ", type=" + type +
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
