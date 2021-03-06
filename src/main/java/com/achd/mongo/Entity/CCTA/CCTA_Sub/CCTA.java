package com.achd.mongo.Entity.CCTA.CCTA_Sub;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class CCTA {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date 检查时间;
    private Integer 年龄;
    private Boolean 冠状动脉CT是否异常;
    private Integer 病变位置;
    private Integer 病变长度;
    private Integer 斑块特征;
    private Double 狭窄度;

    public Date get检查时间() {
        return 检查时间;
    }

    public void set检查时间(Date 检查时间) {
        this.检查时间 = 检查时间;
    }

    public Integer get年龄() {
        return 年龄;
    }

    public void set年龄(Integer 年龄) {
        this.年龄 = 年龄;
    }

    public Boolean get冠状动脉CT是否异常() {
        return 冠状动脉CT是否异常;
    }

    public void set冠状动脉CT是否异常(Boolean 冠状动脉CT是否异常) {
        this.冠状动脉CT是否异常 = 冠状动脉CT是否异常;
    }

    public Integer get病变位置() {
        return 病变位置;
    }

    public void set病变位置(Integer 病变位置) {
        this.病变位置 = 病变位置;
    }

    public Integer get病变长度() {
        return 病变长度;
    }

    public void set病变长度(Integer 病变长度) {
        this.病变长度 = 病变长度;
    }

    public Integer get斑块特征() {
        return 斑块特征;
    }

    public void set斑块特征(Integer 斑块特征) {
        this.斑块特征 = 斑块特征;
    }

    public Double get狭窄度() {
        return 狭窄度;
    }

    public void set狭窄度(Double 狭窄度) {
        this.狭窄度 = 狭窄度;
    }
}
