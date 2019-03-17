package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import com.achd.mongo.Entity.TableBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hypertension extends TableBase {
    private Integer 有无;
    private Integer 目前用药;
    private Integer 用药后达标情况;

    public Hypertension() {
    }

    public Hypertension(Integer 有无, Integer 目前用药, Integer 用药后达标情况) {
        this.有无 = 有无;
        this.目前用药 = 目前用药;
        this.用药后达标情况 = 用药后达标情况;
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

    public Integer get用药后达标情况() {
        return 用药后达标情况;
    }

    public void set用药后达标情况(Integer 用药后达标情况) {
        this.用药后达标情况 = 用药后达标情况;
    }


    public Integer gtExistence() {
        return 有无;
    }

    public void stExistence(Integer 有无) {
        this.有无 = 有无;
    }

    public Integer gtMedicine() {
        return 目前用药;
    }

    public void stMedicine(Integer 目前用药) {
        this.目前用药 = 目前用药;
    }

    public Integer gtResult() {
        return 用药后达标情况;
    }

    public void stResult(Integer 用药后达标情况) {
        this.用药后达标情况 = 用药后达标情况;
    }


}
