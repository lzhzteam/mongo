package com.achd.mongo.Entity.BDT_Sub;


import com.achd.mongo.Entity.BDT_Sub.BDT_Record_Sub.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class BDTS {
    private Integer age;
    private Date time;
    private Integer heartRate;
    private String bloodPressure;
    private Integer height;
    private Integer weight;
    @DBRef
    private Purpose purpose;
    @DBRef
    private Hypertension hypertension;
    @DBRef
    private Dyslipidemia dyslipidemia;
    @DBRef
    private Diabetes diabetes;
    @DBRef
    private Stroke stroke;
    @DBRef
    private PeripheralVascularDisease peripheralVascularDisease;
    @DBRef
    private Smoking smoking;
    @DBRef
    private Drinking drinking;
    @DBRef
    private Exercise exercise;
    @DBRef
    private MyocardialInfarction myocardialInfarcation;
    @DBRef
    private Medication medication;
    @DBRef
    private OtherDisease otherDisease;
    @DBRef
    private FamilyHistory familyHistory;

    public BDTS() {
    }

    public BDTS(Integer age, Date time, Integer heartRate, String bloodPressure, Integer height, Integer weight, Purpose purpose, Hypertension hypertension, Dyslipidemia dyslipidemia, Diabetes diabetes, Stroke stroke, PeripheralVascularDisease peripheralVascularDisease, Smoking smoking, Drinking drinking, Exercise exercise, MyocardialInfarction myocardialInfarcation, Medication medication, OtherDisease otherDisease, FamilyHistory familyHistory) {
        this.age = age;
        this.time = time;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.height = height;
        this.weight = weight;
        this.purpose = purpose;
        this.hypertension = hypertension;
        this.dyslipidemia = dyslipidemia;
        this.diabetes = diabetes;
        this.stroke = stroke;
        this.peripheralVascularDisease = peripheralVascularDisease;
        this.smoking = smoking;
        this.drinking = drinking;
        this.exercise = exercise;
        this.myocardialInfarcation = myocardialInfarcation;
        this.medication = medication;
        this.otherDisease = otherDisease;
        this.familyHistory = familyHistory;
    }

    @Override
    public String toString() {
        return "BDTS{" +
                "age=" + age +
                ", time=" + time +
                ", heartRate=" + heartRate +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", purpose=" + purpose +
                ", hypertension=" + hypertension +
                ", dyslipidemia=" + dyslipidemia +
                ", diabetes=" + diabetes +
                ", stroke=" + stroke +
                ", peripheralVascularDisease=" + peripheralVascularDisease +
                ", smoking=" + smoking +
                ", drinking=" + drinking +
                ", exercise=" + exercise +
                ", myocardialInfarcation=" + myocardialInfarcation +
                ", medication=" + medication +
                ", otherDisease=" + otherDisease +
                ", familyHistory=" + familyHistory +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public Hypertension getHypertension() {
        return hypertension;
    }

    public void setHypertension(Hypertension hypertension) {
        this.hypertension = hypertension;
    }

    public Dyslipidemia getDyslipidemia() {
        return dyslipidemia;
    }

    public void setDyslipidemia(Dyslipidemia dyslipidemia) {
        this.dyslipidemia = dyslipidemia;
    }

    public Diabetes getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Diabetes diabetes) {
        this.diabetes = diabetes;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public PeripheralVascularDisease getPeripheralVascularDisease() {
        return peripheralVascularDisease;
    }

    public void setPeripheralVascularDisease(PeripheralVascularDisease peripheralVascularDisease) {
        this.peripheralVascularDisease = peripheralVascularDisease;
    }

    public Smoking getSmoking() {
        return smoking;
    }

    public void setSmoking(Smoking smoking) {
        this.smoking = smoking;
    }

    public Drinking getDrinking() {
        return drinking;
    }

    public void setDrinking(Drinking drinking) {
        this.drinking = drinking;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public MyocardialInfarction getMyocardialInfarcation() {
        return myocardialInfarcation;
    }

    public void setMyocardialInfarcation(MyocardialInfarction myocardialInfarcation) {
        this.myocardialInfarcation = myocardialInfarcation;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public OtherDisease getOtherDisease() {
        return otherDisease;
    }

    public void setOtherDisease(OtherDisease otherDisease) {
        this.otherDisease = otherDisease;
    }

    public FamilyHistory getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(FamilyHistory familyHistory) {
        this.familyHistory = familyHistory;
    }
}
