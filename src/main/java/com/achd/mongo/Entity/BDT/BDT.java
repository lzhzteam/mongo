package com.achd.mongo.Entity.BDT;


import com.achd.mongo.Entity.BDT.BDT_Sub.BDTS;
import com.achd.mongo.Entity.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;

@Document(collection = "BDT")
public class BDT extends BaseEntity implements Serializable {


    //@DBRef
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
                ", 编号='" + 编号 + '\'' +
                ", 姓名='" + 姓名 + '\'' +
                ", 性别='" + 性别 + '\'' +
                '}';
    }

    public ArrayList<BDTS> getBDTs() {
        return BDTs;
    }

    public void setBDTs(ArrayList<BDTS> BDTs) {
        this.BDTs = BDTs;
    }


}
