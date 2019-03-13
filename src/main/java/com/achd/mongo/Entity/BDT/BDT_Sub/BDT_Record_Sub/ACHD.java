package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ACHD extends TableBase {
    private Integer 有无;
    @DBRef
    private Who 谁;

    public ACHD() {
    }

    public ACHD(Integer 有无, Who 谁) {
        this.有无 = 有无;
        this.谁 = 谁;
    }

    public Integer get有无() {
        return 有无;
    }

    public void set有无(Integer 有无) {
        this.有无 = 有无;
    }

    public Who get谁() {
        return 谁;
    }

    public void set谁(Who 谁) {
        this.谁 = 谁;
    }
}