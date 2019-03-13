package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dyslipidemia extends TableBase {
    private Integer 有无;
    private Integer 目前用药;
    private Integer 用药后控制情况;


    public Dyslipidemia() {
    }

    public Dyslipidemia(Integer 有无, Integer 目前用药, Integer 用药后控制情况) {
        this.有无 = 有无;
        this.目前用药 = 目前用药;
        this.用药后控制情况 = 用药后控制情况;
    }

    public Integer get有无() {
        return 有无;
    }

    public void set有无(Integer 有无) {
        this.有无 = 有无;
    }

    public Integer get目前用药() {
        return 目前用药;
    }

    public void set目前用药(Integer 目前用药) {
        this.目前用药 = 目前用药;
    }

    public Integer get用药后控制情况() {
        return 用药后控制情况;
    }

    public void set用药后控制情况(Integer 用药后控制情况) {
        this.用药后控制情况 = 用药后控制情况;
    }
}
