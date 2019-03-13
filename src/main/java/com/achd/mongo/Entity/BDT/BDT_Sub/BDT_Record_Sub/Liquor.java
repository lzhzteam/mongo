package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Liquor extends TableBase {
    private Integer 毫升;
    private Integer 度数;

    public Liquor() {
    }

    public Liquor(Integer 毫升, Integer 度数) {
        this.毫升 = 毫升;
        this.度数 = 度数;
    }

    public Integer get毫升() {
        return 毫升;
    }

    public void set毫升(Integer 毫升) {
        this.毫升 = 毫升;
    }

    public Integer get度数() {
        return 度数;
    }

    public void set度数(Integer 度数) {
        this.度数 = 度数;
    }
}
