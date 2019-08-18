package com.achd.mongo.Entity.BDT.BDT_Sub;


import com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub.*;
import com.achd.mongo.Entity.TableBase;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class BDT extends TableBase {
    private Integer 年龄;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date 检查时间;
    private Integer 心率;
    private String 血压;
    private Integer 身高;
    private Integer 体重;
    ////@DBRef
    private Purpose 检查目的;
    //@DBRef
    private Hypertension 高血压病;
    //@DBRef
    private Dyslipidemia 血脂异常;
    //@DBRef
    private Diabetes 糖尿病史;
    //@DBRef
    private Stroke 脑卒中病史;
    //@DBRef
    private PeripheralVascularDisease 外周血管病;
    //@DBRef
    private Smoking 吸烟史;
    //@DBRef
    private Drinking 饮酒史;
    //@DBRef
    private Exercise 体育锻炼史;
    //@DBRef
    private MyocardialInfarction 心肌梗死;
    //@DBRef
    private Medication 目前服药;
    //@DBRef
    private OtherDisease 其他疾病史;
    //@DBRef
    private FamilyHistory 家族史;

    public BDT() {
    }

    public BDT(Integer 年龄, Date 检查时间, Integer 心率, String 血压, Integer 身高, Integer 体重, Purpose 检查目的, Hypertension 高血压病, Dyslipidemia 血脂异常, Diabetes 糖尿病史, Stroke 脑卒中病史, PeripheralVascularDisease 外周血管病, Smoking 吸烟史, Drinking 饮酒史, Exercise 体育锻炼史, MyocardialInfarction 心肌梗死, Medication 目前服药, OtherDisease 其他疾病史, FamilyHistory 家族史) {
        this.年龄 = 年龄;
        this.检查时间 = 检查时间;
        this.心率 = 心率;
        this.血压 = 血压;
        this.身高 = 身高;
        this.体重 = 体重;
        this.检查目的 = 检查目的;
        this.高血压病 = 高血压病;
        this.血脂异常 = 血脂异常;
        this.糖尿病史 = 糖尿病史;
        this.脑卒中病史 = 脑卒中病史;
        this.外周血管病 = 外周血管病;
        this.吸烟史 = 吸烟史;
        this.饮酒史 = 饮酒史;
        this.体育锻炼史 = 体育锻炼史;
        this.心肌梗死 = 心肌梗死;
        this.目前服药 = 目前服药;
        this.其他疾病史 = 其他疾病史;
        this.家族史 = 家族史;
    }

    public Integer get年龄() {
        return 年龄;
    }

    public void set年龄(Integer 年龄) {
        this.年龄 = 年龄;
    }

    public Date get检查时间() {
        return 检查时间;
    }

    public void set检查时间(Date 检查时间) {
        this.检查时间 = 检查时间;
    }

    public Integer get心率() {
        return 心率;
    }

    public void set心率(Integer 心率) {
        this.心率 = 心率;
    }

    public String get血压() {
        return 血压;
    }

    public void set血压(String 血压) {
        this.血压 = 血压;
    }

    public Integer get身高() {
        return 身高;
    }

    public void set身高(Integer 身高) {
        this.身高 = 身高;
    }

    public Integer get体重() {
        return 体重;
    }

    public void set体重(Integer 体重) {
        this.体重 = 体重;
    }

    public Purpose get检查目的() {
        return 检查目的;
    }

    public void set检查目的(Purpose 检查目的) {
        this.检查目的 = 检查目的;
    }

    public Hypertension get高血压病() {
        return 高血压病;
    }

    public void set高血压病(Hypertension 高血压病) {
        this.高血压病 = 高血压病;
    }

    public Dyslipidemia get血脂异常() {
        return 血脂异常;
    }

    public void set血脂异常(Dyslipidemia 血脂异常) {
        this.血脂异常 = 血脂异常;
    }

    public Diabetes get糖尿病史() {
        return 糖尿病史;
    }

    public void set糖尿病史(Diabetes 糖尿病史) {
        this.糖尿病史 = 糖尿病史;
    }

    public Stroke get脑卒中病史() {
        return 脑卒中病史;
    }

    public void set脑卒中病史(Stroke 脑卒中病史) {
        this.脑卒中病史 = 脑卒中病史;
    }

    public PeripheralVascularDisease get外周血管病() {
        return 外周血管病;
    }

    public void set外周血管病(PeripheralVascularDisease 外周血管病) {
        this.外周血管病 = 外周血管病;
    }

    public Smoking get吸烟史() {
        return 吸烟史;
    }

    public void set吸烟史(Smoking 吸烟史) {
        this.吸烟史 = 吸烟史;
    }

    public Drinking get饮酒史() {
        return 饮酒史;
    }

    public void set饮酒史(Drinking 饮酒史) {
        this.饮酒史 = 饮酒史;
    }

    public Exercise get体育锻炼史() {
        return 体育锻炼史;
    }

    public void set体育锻炼史(Exercise 体育锻炼史) {
        this.体育锻炼史 = 体育锻炼史;
    }

    public MyocardialInfarction get心肌梗死() {
        return 心肌梗死;
    }

    public void set心肌梗死(MyocardialInfarction 心肌梗死) {
        this.心肌梗死 = 心肌梗死;
    }

    public Medication get目前服药() {
        return 目前服药;
    }

    public void set目前服药(Medication 目前服药) {
        this.目前服药 = 目前服药;
    }

    public OtherDisease get其他疾病史() {
        return 其他疾病史;
    }

    public void set其他疾病史(OtherDisease 其他疾病史) {
        this.其他疾病史 = 其他疾病史;
    }

    public FamilyHistory get家族史() {
        return 家族史;
    }

    public void set家族史(FamilyHistory 家族史) {
        this.家族史 = 家族史;
    }


    ////////////////呕//////


    public Integer gtAge() {
        return 年龄;
    }

    public void stAge(Integer 年龄) {
        this.年龄 = 年龄;
    }

    public Date gtTime() {
        return 检查时间;
    }

    public void stTime(Date 检查时间) {
        this.检查时间 = 检查时间;
    }

    public Integer gtHeartRate() {
        return 心率;
    }

    public void stHeartRate(Integer 心率) {
        this.心率 = 心率;
    }

    public String gtBloodPressure() {
        return 血压;
    }

    public void stBloodPressure(String 血压) {
        this.血压 = 血压;
    }

    public Integer gtHeight() {
        return 身高;
    }

    public void stHeight(Integer 身高) {
        this.身高 = 身高;
    }

    public Integer gtWeight() {
        return 体重;
    }

    public void stWeight(Integer 体重) {
        this.体重 = 体重;
    }

    public Purpose gtPurpose() {
        return 检查目的;
    }

    public void stPurpose(Purpose 检查目的) {
        this.检查目的 = 检查目的;
    }

    public Hypertension gtHypertension() {
        return 高血压病;
    }

    public void stHypertension(Hypertension 高血压病) {
        this.高血压病 = 高血压病;
    }

    public Dyslipidemia gtDyslipidemia() {
        return 血脂异常;
    }

    public void stDyslipidemia(Dyslipidemia 血脂异常) {
        this.血脂异常 = 血脂异常;
    }

    public Diabetes gtDiabetes() {
        return 糖尿病史;
    }

    public void stDiabetes(Diabetes 糖尿病史) {
        this.糖尿病史 = 糖尿病史;
    }

    public Stroke gtStroke() {
        return 脑卒中病史;
    }

    public void stStroke(Stroke 脑卒中病史) {
        this.脑卒中病史 = 脑卒中病史;
    }

    public PeripheralVascularDisease gtPeripheralVascularDisease() {
        return 外周血管病;
    }

    public void stPeripheralVascularDisease(PeripheralVascularDisease 外周血管病) {
        this.外周血管病 = 外周血管病;
    }

    public Smoking gtSmoking() {
        return 吸烟史;
    }

    public void stSmoking(Smoking 吸烟史) {
        this.吸烟史 = 吸烟史;
    }

    public Drinking gtDrinking() {
        return 饮酒史;
    }

    public void stDrinking(Drinking 饮酒史) {
        this.饮酒史 = 饮酒史;
    }

    public Exercise gtExercise() {
        return 体育锻炼史;
    }

    public void stExercise(Exercise 体育锻炼史) {
        this.体育锻炼史 = 体育锻炼史;
    }

    public MyocardialInfarction gtMyocardialInfarction() {
        return 心肌梗死;
    }

    public void stMyocardialInfarction(MyocardialInfarction 心肌梗死) {
        this.心肌梗死 = 心肌梗死;
    }

    public Medication gtMedication() {
        return 目前服药;
    }

    public void stMedication(Medication 目前服药) {
        this.目前服药 = 目前服药;
    }

    public OtherDisease gtOtherDisease() {
        return 其他疾病史;
    }

    public void stOtherDisease(OtherDisease 其他疾病史) {
        this.其他疾病史 = 其他疾病史;
    }

    public FamilyHistory gtFamilyHistory() {
        return 家族史;
    }

    public void stFamilyHistory(FamilyHistory 家族史) {
        this.家族史 = 家族史;
    }
}
