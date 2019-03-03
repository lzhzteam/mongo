package com.achd.mongo.Entity.CCTA;

import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTAs;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;

@Document(collection = "CCTA")
public class CCTA extends BaseEntity implements Serializable {
    @DBRef
    private ArrayList<CCTAs> CCTAs;

    public CCTA() {
    }

    public CCTA(ArrayList<CCTAs> CCTAs) {
        this.CCTAs = CCTAs;
    }

    public ArrayList<CCTAs> getCCTAs() {
        return CCTAs;
    }

    public void setCCTAs(ArrayList<CCTAs> CCTAs) {
        this.CCTAs = CCTAs;
    }


}
