package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dyslipidemia extends TableBase {
    private Integer existence;
    private Integer medication;
    private Integer compliance;


    public Dyslipidemia() {
    }

    public Dyslipidemia(Integer existence, Integer medication, Integer compliance) {
        this.existence = existence;
        this.medication = medication;
        this.compliance = compliance;
    }

    @Override
    public String toString() {
        return "Dyslipidemia{" +
                "existence=" + existence +
                ", medication=" + medication +
                ", compliance=" + compliance +
                '}';
    }

    public Integer getExistence() {
        return existence;
    }

    public void setExistence(Integer existence) {
        this.existence = existence;
    }

    public Integer getMedication() {
        return medication;
    }

    public void setMedication(Integer medication) {
        this.medication = medication;
    }

    public Integer getCompliance() {
        return compliance;
    }

    public void setCompliance(Integer compliance) {
        this.compliance = compliance;
    }
}
