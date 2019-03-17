package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import com.achd.mongo.Entity.TableBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ps extends TableBase {

    //    @DBRef
    private Liquor 白酒;

    private Integer 红酒;
    private Integer 啤酒;
    private Integer 黄酒;


    public Ps() {
    }

    public Ps(Liquor 白酒, Integer 红酒, Integer 啤酒, Integer 黄酒) {
        this.白酒 = 白酒;
        this.红酒 = 红酒;
        this.啤酒 = 啤酒;
        this.黄酒 = 黄酒;
    }

    public Liquor get白酒() {
        return 白酒;
    }

    public void set白酒(Liquor 白酒) {
        this.白酒 = 白酒;
    }

    public Integer get红酒() {
        return 红酒;
    }

    public void set红酒(Integer 红酒) {
        this.红酒 = 红酒;
    }

    public Integer get啤酒() {
        return 啤酒;
    }

    public void set啤酒(Integer 啤酒) {
        this.啤酒 = 啤酒;
    }

    public Integer get黄酒() {
        return 黄酒;
    }

    public void set黄酒(Integer 黄酒) {
        this.黄酒 = 黄酒;
    }


    public Liquor gtLiquor() {
        return 白酒;
    }

    public void stLiquor(Liquor 白酒) {
        this.白酒 = 白酒;
    }

    public Integer gtRedwine() {
        return 红酒;
    }

    public void stRedwine(Integer 红酒) {
        this.红酒 = 红酒;
    }

    public Integer gtBeer() {
        return 啤酒;
    }

    public void stBeer(Integer 啤酒) {
        this.啤酒 = 啤酒;
    }

    public Integer gtYellowwine() {
        return 黄酒;
    }

    public void stYellowwine(Integer 黄酒) {
        this.黄酒 = 黄酒;
    }
}
