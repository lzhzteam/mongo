package com.achd.mongo.Entity.BDT;


import com.achd.mongo.Entity.BDT.BDT_Sub.BDTS;
import com.achd.mongo.Entity.BaseEntity;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;

@Document(collection = "BDT")
public class BDT extends BaseEntity implements Serializable {


    @DBRef
    private ArrayList<BDTS> BDTs;

    public BDT() {
    }

    public BDT(ArrayList<BDTS> BDTs) {
        this.BDTs = BDTs;
    }


    @Override
    public String toString() {
        return "BDT{" +
                "BDTs=" + BDTs +
                ", id='" + id + '\'' +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
