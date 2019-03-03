package com.achd.mongo.Entity.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Ps {

    @DBRef
    private Liquor liquor;

    private Integer redWine;
    private Integer beer;
    private Integer yellowWine;


    public Ps() {
    }


    @Override
    public String toString() {
        return "Ps{" +
                "liquor=" + liquor +
                ", redWine=" + redWine +
                ", beer=" + beer +
                ", yellowWine=" + yellowWine +
                '}';
    }

    public Ps(Liquor liquor, Integer redWine, Integer beer, Integer yellowWine) {
        this.liquor = liquor;
        this.redWine = redWine;
        this.beer = beer;
        this.yellowWine = yellowWine;
    }

    public Liquor getLiquor() {
        return liquor;
    }

    public void setLiquor(Liquor liquor) {
        this.liquor = liquor;
    }

    public Integer getRedWine() {
        return redWine;
    }

    public void setRedWine(Integer redWine) {
        this.redWine = redWine;
    }

    public Integer getBeer() {
        return beer;
    }

    public void setBeer(Integer beer) {
        this.beer = beer;
    }

    public Integer getYellowWine() {
        return yellowWine;
    }

    public void setYellowWine(Integer yellowWine) {
        this.yellowWine = yellowWine;
    }
}
