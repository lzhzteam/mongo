package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FamilyHistory extends TableBase {
    //    @DBRef
    private ACHD 冠心病家族史;
    private Integer 高脂血症家族史;
    private String 其它;

    public FamilyHistory() {
    }

    public FamilyHistory(ACHD 冠心病家族史, Integer 高脂血症家族史, String 其它) {
        this.冠心病家族史 = 冠心病家族史;
        this.高脂血症家族史 = 高脂血症家族史;
        this.其它 = 其它;
    }

    public ACHD get冠心病家族史() {
        return 冠心病家族史;
    }

    public void set冠心病家族史(ACHD 冠心病家族史) {
        this.冠心病家族史 = 冠心病家族史;
    }

    public Integer get高脂血症家族史() {
        return 高脂血症家族史;
    }

    public void set高脂血症家族史(Integer 高脂血症家族史) {
        this.高脂血症家族史 = 高脂血症家族史;
    }

    public String get其它() {
        return 其它;
    }

    public void set其它(String 其它) {
        this.其它 = 其它;
    }


    public ACHD gtACHD() {
        return 冠心病家族史;
    }

    public void stACHD(ACHD 冠心病家族史) {
        this.冠心病家族史 = 冠心病家族史;
    }

    public Integer gtHyperlipemia() {
        return 高脂血症家族史;
    }

    public void stHyperlipemia(Integer 高脂血症家族史) {
        this.高脂血症家族史 = 高脂血症家族史;
    }

    public String gtOther() {
        return 其它;
    }

    public void stOther(String 其它) {
        this.其它 = 其它;
    }
}
