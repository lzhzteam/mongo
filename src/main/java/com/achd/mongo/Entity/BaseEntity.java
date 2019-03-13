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
}
