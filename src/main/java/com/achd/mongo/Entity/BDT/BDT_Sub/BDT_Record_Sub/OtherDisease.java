package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OtherDisease {
    private Boolean hepaticInsufficiency;
    private Boolean renalInsufficiency;
    private Boolean tumor;
    private String others;

    public OtherDisease(Boolean hepaticInsufficiency, Boolean renalInsufficiency, Boolean tumor, String others) {
        this.hepaticInsufficiency = hepaticInsufficiency;
        this.renalInsufficiency = renalInsufficiency;
        this.tumor = tumor;
        this.others = others;
    }

    public OtherDisease() {
    }

    @Override
    public String toString() {
        return "OtherDisease{" +
                "hepaticInsufficiency=" + hepaticInsufficiency +
                ", renalInsufficiency=" + renalInsufficiency +
                ", tumor=" + tumor +
                ", others='" + others + '\'' +
                '}';
    }

    public Boolean getHepaticInsufficiency() {
        return hepaticInsufficiency;
    }

    public void setHepaticInsufficiency(Boolean hepaticInsufficiency) {
        this.hepaticInsufficiency = hepaticInsufficiency;
    }

    public Boolean getRenalInsufficiency() {
        return renalInsufficiency;
    }

    public void setRenalInsufficiency(Boolean renalInsufficiency) {
        this.renalInsufficiency = renalInsufficiency;
    }

    public Boolean getTumor() {
        return tumor;
    }

    public void setTumor(Boolean tumor) {
        this.tumor = tumor;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
