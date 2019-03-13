package com.achd.mongo.Entity;

import org.springframework.data.annotation.Id;

public class BaseEntity {
    @Id
    public String id;

    //编号
    public String 编号;

    //姓名
    public String 姓名;

    //性别
    public String 性别;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get编号() {
        return 编号;
    }


    public void set编号(String 编号) {
        this.编号 = 编号;
    }

    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }


    public void stNum(String 编号) {
        this.编号 = 编号;
    }

    public String gtNum() {
        return 编号;
    }


    public void stName(String 姓名) {
        this.姓名 = 姓名;
    }


    public String gtName() {
        return 姓名;
    }


    public void stSex(String 性别) {
        this.性别 = 性别;
    }


    public String gtSex() {
        return 性别;
    }
}
