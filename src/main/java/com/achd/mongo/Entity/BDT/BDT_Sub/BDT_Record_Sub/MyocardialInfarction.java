package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;

import com.achd.mongo.Entity.TableBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MyocardialInfarction extends TableBase {
    private Integer 有无;
    private String 年月;

    public MyocardialInfarction() {
    }

    public MyocardialInfarction(Integer 有无, String 年月) {
        this.有无 = 有无;
        this.年月 = 年月;
    }

    public Integer get有无() {
        return 有无;
    }

    public void set有无(Integer 有无) {
        this.有无 = 有无;
    }

    public String get年月() {
        return 年月;
    }

    public void set年月(String 年月) {
        this.年月 = 年月;
    }


    public Integer gtExistence() {
        return 有无;
    }

    public void stExistence(Integer 有无) {
        this.有无 = 有无;
    }

    public String gtYearMonth() {
        return 年月;
    }

    public void stYearMonth(String 年月) {
        this.年月 = 年月;
    }


}
