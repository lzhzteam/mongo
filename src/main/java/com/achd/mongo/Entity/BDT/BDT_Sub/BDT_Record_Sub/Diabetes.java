package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Diabetes extends TableBase {
    private Integer 有无;
    private Integer 分型;
    private Integer 目前用药;
    private Integer 用药后控制异常;


    public Diabetes() {
    }

    public Diabetes(Integer 有无, Integer 分型, Integer 目前用药, Integer 用药后控制异常) {
        this.有无 = 有无;
        this.分型 = 分型;
        this.目前用药 = 目前用药;
        this.用药后控制异常 = 用药后控制异常;
    }

    public Integer get有无() {
        return 有无;
    }

    public void set有无(Integer 有无) {
        this.有无 = 有无;
    }

    public Integer get分型() {
        return 分型;
    }

    public void set分型(Integer 分型) {
        this.分型 = 分型;
    }

    public Integer get目前用药() {
        return 目前用药;
    }

    public void set目前用药(Integer 目前用药) {
        this.目前用药 = 目前用药;
    }

    public Integer get用药后控制异常() {
        return 用药后控制异常;
    }

    public void set用药后控制异常(Integer 用药后控制异常) {
        this.用药后控制异常 = 用药后控制异常;
    }


    public Integer gtExistence() {
        return 有无;
    }

    public void stExistence(Integer 有无) {
        this.有无 = 有无;
    }

    public Integer gtType() {
        return 分型;
    }

    public void stType(Integer 分型) {
        this.分型 = 分型;
    }

    public Integer gtMedicine() {
        return 目前用药;
    }

    public void stMedicine(Integer 目前用药) {
        this.目前用药 = 目前用药;
    }

    public Integer gtResult() {
        return 用药后控制异常;
    }

    public void stResult(Integer 用药后控制异常) {
        this.用药后控制异常 = 用药后控制异常;
    }
}
