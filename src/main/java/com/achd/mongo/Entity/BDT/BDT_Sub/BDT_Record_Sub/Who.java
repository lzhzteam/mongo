package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import com.achd.mongo.Entity.TableBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Who extends TableBase {
    private Integer 父亲;
    private Integer 母亲;
    private Integer 兄弟姐妹;
    private Integer 子女;

    public Who() {
    }

    public Who(Integer 父亲, Integer 母亲, Integer 兄弟姐妹, Integer 子女) {
        this.父亲 = 父亲;
        this.母亲 = 母亲;
        this.兄弟姐妹 = 兄弟姐妹;
        this.子女 = 子女;
    }

    public Integer get父亲() {
        return 父亲;
    }

    public void set父亲(Integer 父亲) {
        this.父亲 = 父亲;
    }

    public Integer get母亲() {
        return 母亲;
    }

    public void set母亲(Integer 母亲) {
        this.母亲 = 母亲;
    }

    public Integer get兄弟姐妹() {
        return 兄弟姐妹;
    }

    public void set兄弟姐妹(Integer 兄弟姐妹) {
        this.兄弟姐妹 = 兄弟姐妹;
    }

    public Integer get子女() {
        return 子女;
    }

    public void set子女(Integer 子女) {
        this.子女 = 子女;
    }


    public Integer gtFather() {
        return 父亲;
    }

    public void stFather(Integer 父亲) {
        this.父亲 = 父亲;
    }

    public Integer gtMother() {
        return 母亲;
    }

    public void stMother(Integer 母亲) {
        this.母亲 = 母亲;
    }

    public Integer gtCousin() {
        return 兄弟姐妹;
    }

    public void stCousin(Integer 兄弟姐妹) {
        this.兄弟姐妹 = 兄弟姐妹;
    }

    public Integer gtChild() {
        return 子女;
    }

    public void stChild(Integer 子女) {
        this.子女 = 子女;
    }




}
