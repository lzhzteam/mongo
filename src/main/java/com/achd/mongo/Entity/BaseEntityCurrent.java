package com.achd.mongo.Entity;

import com.achd.mongo.Entity.BDT.BDT_Sub.BDT;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTA;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "BaseEntityCurrent")
public class BaseEntityCurrent {

    @Id
    private String id;

    //编号
    private String 编号;

    //姓名
    private String 姓名;

    //性别
    private String 性别;

    private BDT bdt;

    private CCTA ccta;

    public BaseEntityCurrent(String 编号, String 姓名, String 性别, BDT bdt, CCTA ccta) {
        this.编号 = 编号;
        this.姓名 = 姓名;
        this.性别 = 性别;
        this.bdt = bdt;
        this.ccta = ccta;
    }
}
