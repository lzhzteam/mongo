package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Who{
    private Integer father;
    private Integer mother;

    public Who() {
    }

    public Who(Integer father, Integer mother) {
        this.father = father;
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Who{" +
                "father=" + father +
                ", mother=" + mother +
                '}';
    }

    public Integer getFather() {
        return father;
    }

    public void setFather(Integer father) {
        this.father = father;
    }

    public Integer getMother() {
        return mother;
    }

    public void setMother(Integer mother) {
        this.mother = mother;
    }
}
