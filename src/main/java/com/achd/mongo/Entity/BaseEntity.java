package com.achd.mongo.Entity;

import com.achd.mongo.Entity.BDT.BDT_Sub.BDTS;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTA;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Document(collection = "BaseEntity")
public class BaseEntity implements Serializable {
    @Id
    private String id;

    //编号
    private String 编号;

    //姓名
    private String 姓名;

    //性别
    private String 性别;

    /////////////BDT///////////
    public ArrayList<BDTS> BDTs = new ArrayList<>();
    ///////////CCTA///////////
    public ArrayList<CCTA> CCTAs = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get编号() {
        return 编号;
    }

    public void set编号(String 编号) {
        this.编号 = 编号;
    }

    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }

    public ArrayList<BDTS> getBDTs() {
        return BDTs;
    }

    public void setBDTs(ArrayList<BDTS> BDTs) {
        this.BDTs = BDTs;
    }

    public void addBDTs(ArrayList<BDTS> BDTs) {
        this.BDTs.addAll(BDTs);
    }

    public ArrayList<CCTA> getCCTAs() {
        return CCTAs;
    }

    public void setCCTAs(ArrayList<CCTA> CCTAs) {
        this.CCTAs = CCTAs;
    }

    public void addCCTAs(ArrayList<CCTA> CCTAs) {
        this.CCTAs.addAll(CCTAs);
    }
}
