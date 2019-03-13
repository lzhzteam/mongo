package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OtherDisease extends TableBase {
    private Boolean 肝功能不全;
    private Boolean 肾功能不全;
    private Boolean 肿瘤;
    private String 其它;

    public OtherDisease() {
    }

    public OtherDisease(Boolean 肝功能不全, Boolean 肾功能不全, Boolean 肿瘤, String 其它) {
        this.肝功能不全 = 肝功能不全;
        this.肾功能不全 = 肾功能不全;
        this.肿瘤 = 肿瘤;
        this.其它 = 其它;
    }

    public Boolean get肝功能不全() {
        return 肝功能不全;
    }

    public void set肝功能不全(Boolean 肝功能不全) {
        this.肝功能不全 = 肝功能不全;
    }

    public Boolean get肾功能不全() {
        return 肾功能不全;
    }

    public void set肾功能不全(Boolean 肾功能不全) {
        this.肾功能不全 = 肾功能不全;
    }

    public Boolean get肿瘤() {
        return 肿瘤;
    }

    public void set肿瘤(Boolean 肿瘤) {
        this.肿瘤 = 肿瘤;
    }

    public String get其它() {
        return 其它;
    }

    public void set其它(String 其它) {
        this.其它 = 其它;
    }


    public Boolean gtHepaticinsufficiency() {
        return 肝功能不全;
    }

    public void stHepaticinsufficiency(Boolean 肝功能不全) {
        this.肝功能不全 = 肝功能不全;
    }

    public Boolean gtRenalinadequacy() {
        return 肾功能不全;
    }

    public void stRenalinadequacy(Boolean 肾功能不全) {
        this.肾功能不全 = 肾功能不全;
    }

    public Boolean gtTumor() {
        return 肿瘤;
    }

    public void stTumor(Boolean 肿瘤) {
        this.肿瘤 = 肿瘤;
    }

    public String gtOther() {
        return 其它;
    }

    public void stOther(String 其它) {
        this.其它 = 其它;
    }


}
