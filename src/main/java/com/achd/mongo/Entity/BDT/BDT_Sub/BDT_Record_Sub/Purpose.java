package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Purpose {
    private Boolean typicalAngina;
    private Boolean atypicalChestDiscomfort;
    private Boolean non_chestPainSymptoms;
    private Boolean abnormalECG;
    private Boolean abnormalHeartUltrasound;
    private String others;

    public Purpose() {
    }

    public Purpose(Boolean typicalAngina, Boolean atypicalChestDiscomfort, Boolean non_chestPainSymptoms, Boolean abnormalECG, Boolean abnormalHeartUltrasound, String others) {
        this.typicalAngina = typicalAngina;
        this.atypicalChestDiscomfort = atypicalChestDiscomfort;
        this.non_chestPainSymptoms = non_chestPainSymptoms;
        this.abnormalECG = abnormalECG;
        this.abnormalHeartUltrasound = abnormalHeartUltrasound;
        this.others = others;
    }

    @Override
    public String toString() {
        return "Purpose{" +
                "typicalAngina=" + typicalAngina +
                ", atypicalChestDiscomfort=" + atypicalChestDiscomfort +
                ", non_chestPainSymptoms=" + non_chestPainSymptoms +
                ", abnormalECG=" + abnormalECG +
                ", abnormalHeartUltrasound=" + abnormalHeartUltrasound +
                ", others='" + others + '\'' +
                '}';
    }

    public Boolean getTypicalAngina() {
        return typicalAngina;
    }

    public void setTypicalAngina(Boolean typicalAngina) {
        this.typicalAngina = typicalAngina;
    }

    public Boolean getAtypicalChestDiscomfort() {
        return atypicalChestDiscomfort;
    }

    public void setAtypicalChestDiscomfort(Boolean atypicalChestDiscomfort) {
        this.atypicalChestDiscomfort = atypicalChestDiscomfort;
    }

    public Boolean getNon_chestPainSymptoms() {
        return non_chestPainSymptoms;
    }

    public void setNon_chestPainSymptoms(Boolean non_chestPainSymptoms) {
        this.non_chestPainSymptoms = non_chestPainSymptoms;
    }

    public Boolean getAbnormalECG() {
        return abnormalECG;
    }

    public void setAbnormalECG(Boolean abnormalECG) {
        this.abnormalECG = abnormalECG;
    }

    public Boolean getAbnormalHeartUltrasound() {
        return abnormalHeartUltrasound;
    }

    public void setAbnormalHeartUltrasound(Boolean abnormalHeartUltrasound) {
        this.abnormalHeartUltrasound = abnormalHeartUltrasound;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
