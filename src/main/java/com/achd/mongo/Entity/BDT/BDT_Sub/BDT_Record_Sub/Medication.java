package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import com.achd.mongo.Entity.TableBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Medication extends TableBase {
    private Boolean 阿司匹林;
    private Boolean 硫酸氢氯吡格雷;
    private Boolean 硝酸酯类药物;
    private Boolean 华法林等抗凝药;

    public Medication() {
    }

    public Medication(Boolean 阿司匹林, Boolean 硫酸氢氯吡格雷, Boolean 硝酸酯类药物, Boolean 华法林等抗凝药) {
        this.阿司匹林 = 阿司匹林;
        this.硫酸氢氯吡格雷 = 硫酸氢氯吡格雷;
        this.硝酸酯类药物 = 硝酸酯类药物;
        this.华法林等抗凝药 = 华法林等抗凝药;
    }

    public Boolean get阿司匹林() {
        return 阿司匹林;
    }

    public void set阿司匹林(Boolean 阿司匹林) {
        this.阿司匹林 = 阿司匹林;
    }

    public Boolean get硫酸氢氯吡格雷() {
        return 硫酸氢氯吡格雷;
    }

    public void set硫酸氢氯吡格雷(Boolean 硫酸氢氯吡格雷) {
        this.硫酸氢氯吡格雷 = 硫酸氢氯吡格雷;
    }

    public Boolean get硝酸酯类药物() {
        return 硝酸酯类药物;
    }

    public void set硝酸酯类药物(Boolean 硝酸酯类药物) {
        this.硝酸酯类药物 = 硝酸酯类药物;
    }

    public Boolean get华法林等抗凝药() {
        return 华法林等抗凝药;
    }

    public void set华法林等抗凝药(Boolean 华法林等抗凝药) {
        this.华法林等抗凝药 = 华法林等抗凝药;
    }


    public Boolean gtAspirin() {
        return 阿司匹林;
    }

    public void stAspirin(Boolean 阿司匹林) {
        this.阿司匹林 = 阿司匹林;
    }

    public Boolean gtClopidogrelhydrogen() {
        return 硫酸氢氯吡格雷;
    }

    public void stClopidogrelhydrogen(Boolean 硫酸氢氯吡格雷) {
        this.硫酸氢氯吡格雷 = 硫酸氢氯吡格雷;
    }

    public Boolean gtNitricether() {
        return 硝酸酯类药物;
    }

    public void stNitricether(Boolean 硝酸酯类药物) {
        this.硝酸酯类药物 = 硝酸酯类药物;
    }

    public Boolean gtWarfarin() {
        return 华法林等抗凝药;
    }

    public void stWarfarin(Boolean 华法林等抗凝药) {
        this.华法林等抗凝药 = 华法林等抗凝药;
    }

}
