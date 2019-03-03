package com.achd.mongo.Entity.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Diabetes {
    private Integer existence;
    private Integer type;
    private Integer medication;
    private Integer compliance;


    public Diabetes() {
    }

    public Diabetes(Integer existence, Integer type, Integer medication, Integer compliance) {
        this.existence = existence;
        this.type = type;
        this.medication = medication;
        this.compliance = compliance;
    }

    @Override
    public String toString() {
        return "Diabetes{" +
                "existence=" + existence +
                ", type=" + type +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
