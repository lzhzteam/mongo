package com.achd.mongo.Entity;


import com.achd.mongo.Entity.BDT_Sub.BDTS;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@Document(collection = "BDT")
public class BDT extends BaseEntity implements Serializable {

    //姓名
    private String name;

    //性别
    private String gender;

    @DBRef
    private ArrayList<BDTS> BDTs;

    public BDT() {
    }

    public BDT(String name, String gender, ArrayList<BDTS> BDTs) {
        this.name = name;
        this.gender = gender;
        this.BDTs = BDTs;
    }

    @Override
    public String toString() {
        return "BDT{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", BDTs=" + BDTs +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<BDTS> getBDTs() {
        return BDTs;
    }

    public void setBDTs(ArrayList<BDTS> BDTs) {
        this.BDTs = BDTs;
    }

    public void addBDT(BDTS bdts) {
        this.BDTs.add(bdts);
    }
}
