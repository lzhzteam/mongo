package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FamilyHistory extends TableBase {
    @DBRef
    private ACHD achd;
    private Integer hyperlipidemia;
    private String others;

    public FamilyHistory() {
    }

    public FamilyHistory(ACHD achd, Integer hyperlipidemia, String others) {
        this.achd = achd;
        this.hyperlipidemia = hyperlipidemia;
        this.others = others;
    }

    @Override
    public String toString() {
        return "FamilyHistory{" +
                "Achd=" + achd +
                ", hyperlipidemia=" + hyperlipidemia +
                ", others='" + others + '\'' +
                '}';
    }

    public ACHD getAchd() {
        return achd;
    }

    public void setAchd(ACHD achd) {
        this.achd = achd;
    }

    public Integer getHyperlipidemia() {
        return hyperlipidemia;
    }

    public void setHyperlipidemia(Integer hyperlipidemia) {
        this.hyperlipidemia = hyperlipidemia;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
