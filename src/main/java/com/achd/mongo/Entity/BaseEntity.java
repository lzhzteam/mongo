package com.achd.mongo.Entity;

import org.springframework.data.annotation.Id;

public class BaseEntity {
    @Id
    public String id;

    //编号
    public String num;

    //姓名
    public String name;

    //性别
    public String gender;
}
