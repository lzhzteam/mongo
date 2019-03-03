package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Liquor {
    private Integer ml;
    private Integer degree;

    public Liquor() {
    }

    public Liquor(Integer ml, Integer degree) {
        this.ml = ml;
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Liquor{" +
                "ml=" + ml +
                ", degree=" + degree +
                '}';
    }

    public Integer getMl() {
        return ml;
    }

    public void setMl(Integer ml) {
        this.ml = ml;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }
}
