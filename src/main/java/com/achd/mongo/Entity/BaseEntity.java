package com.achd.mongo.Entity;

import org.springframework.data.annotation.Id;

public class BaseEntity {
    @Id
    //id
    public String id;

    //姓名
    public String name;

    //性别
    public String gender;
}
