package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import com.achd.mongo.Entity.TableBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Purpose extends TableBase {
    private Boolean 典型心绞痛;
    private Boolean 非典型性胸部不适;
    private Boolean 非胸痛症状;
    private Boolean 心电图异常;
    private Boolean 心脏超声异常;
    private String 其它;

    public Purpose() {
    }

    public Purpose(Boolean 典型心绞痛, Boolean 非典型性胸部不适, Boolean 非胸痛症状, Boolean 心电图异常, Boolean 心脏超声异常, String 其它) {
        this.典型心绞痛 = 典型心绞痛;
        this.非典型性胸部不适 = 非典型性胸部不适;
        this.非胸痛症状 = 非胸痛症状;
        this.心电图异常 = 心电图异常;
        this.心脏超声异常 = 心脏超声异常;
        this.其它 = 其它;
    }

    public Boolean get典型心绞痛() {
        return 典型心绞痛;
    }

    public void set典型心绞痛(Boolean 典型心绞痛) {
        this.典型心绞痛 = 典型心绞痛;
    }

    public Boolean get非典型性胸部不适() {
        return 非典型性胸部不适;
    }

    public void set非典型性胸部不适(Boolean 非典型性胸部不适) {
        this.非典型性胸部不适 = 非典型性胸部不适;
    }

    public Boolean get非胸痛症状() {
        return 非胸痛症状;
    }

    public void set非胸痛症状(Boolean 非胸痛症状) {
        this.非胸痛症状 = 非胸痛症状;
    }

    public Boolean get心电图异常() {
        return 心电图异常;
    }

    public void set心电图异常(Boolean 心电图异常) {
        this.心电图异常 = 心电图异常;
    }

    public Boolean get心脏超声异常() {
        return 心脏超声异常;
    }

    public void set心脏超声异常(Boolean 心脏超声异常) {
        this.心脏超声异常 = 心脏超声异常;
    }

    public String get其它() {
        return 其它;
    }

    public void set其它(String 其它) {
        this.其它 = 其它;
    }


    public Boolean gtTypicalangina() {
        return 典型心绞痛;
    }

    public void stTypicalangina(Boolean 点型心绞痛) {
        this.典型心绞痛 = 点型心绞痛;
    }

    public Boolean gtAtypicalchestdiscomfort() {
        return 非典型性胸部不适;
    }

    public void stAtypicalchestdiscomfort(Boolean 非典型性胸部不适) {
        this.非典型性胸部不适 = 非典型性胸部不适;
    }

    public Boolean gtNonchestpainsymptoms() {
        return 非胸痛症状;
    }

    public void stNonchestpainsymptoms(Boolean 非胸痛症状) {
        this.非胸痛症状 = 非胸痛症状;
    }

    public Boolean gtElectrocardiographicabnormality() {
        return 心电图异常;
    }

    public void stElectrocardiographicabnormality(Boolean 心电图异常) {
        this.心电图异常 = 心电图异常;
    }

    public Boolean gtHeartultrasonicabnormal() {
        return 心脏超声异常;
    }

    public void stHeartultrasonicabnormal(Boolean 心脏超声异常) {
        this.心脏超声异常 = 心脏超声异常;
    }

    public String gtOther() {
        return 其它;
    }

    public void stOther(String 其它) {
        this.其它 = 其它;
    }



}
