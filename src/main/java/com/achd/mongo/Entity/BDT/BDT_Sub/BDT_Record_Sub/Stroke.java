package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stroke extends TableBase {
    private Integer 有无;
    private String 发生时间;
    private String 发声部位;
    private Integer 类型;

    public Stroke() {
    }

    public Stroke(Integer 有无, String 发生时间, String 发声部位, Integer 类型) {
        this.有无 = 有无;
        this.发生时间 = 发生时间;
        this.发声部位 = 发声部位;
        this.类型 = 类型;
    }

    public Integer get有无() {
        return 有无;
    }

    public void set有无(Integer 有无) {
        this.有无 = 有无;
    }

    public String get发生时间() {
        return 发生时间;
    }

    public void set发生时间(String 发生时间) {
        this.发生时间 = 发生时间;
    }

    public String get发声部位() {
        return 发声部位;
    }

    public void set发声部位(String 发声部位) {
        this.发声部位 = 发声部位;
    }

    public Integer get类型() {
        return 类型;
    }

    public void set类型(Integer 类型) {
        this.类型 = 类型;
    }
}
