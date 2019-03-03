package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Medication {
    private Boolean aspirin;
    private Boolean clopidogrelSulfate;
    private Boolean nitrateDrug;
    private Boolean warfarin;

    public Medication() {
    }

    public Medication(Boolean aspirin, Boolean clopidogrelSulfate, Boolean nitrateDrug, Boolean warfarin) {
        this.aspirin = aspirin;
        this.clopidogrelSulfate = clopidogrelSulfate;
        this.nitrateDrug = nitrateDrug;
        this.warfarin = warfarin;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "aspirin=" + aspirin +
                ", clopidogrelSulfate=" + clopidogrelSulfate +
                ", nitrateDrug=" + nitrateDrug +
                ", warfarin=" + warfarin +
                '}';
    }

    public Boolean getAspirin() {
        return aspirin;
    }

    public void setAspirin(Boolean aspirin) {
        this.aspirin = aspirin;
    }

    public Boolean getClopidogrelSulfate() {
        return clopidogrelSulfate;
    }

    public void setClopidogrelSulfate(Boolean clopidogrelSulfate) {
        this.clopidogrelSulfate = clopidogrelSulfate;
    }

    public Boolean getNitrateDrug() {
        return nitrateDrug;
    }

    public void setNitrateDrug(Boolean nitrateDrug) {
        this.nitrateDrug = nitrateDrug;
    }

    public Boolean getWarfarin() {
        return warfarin;
    }

    public void setWarfarin(Boolean warfarin) {
        this.warfarin = warfarin;
    }
}
