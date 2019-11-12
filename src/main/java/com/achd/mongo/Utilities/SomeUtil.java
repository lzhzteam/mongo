package com.achd.mongo.Utilities;

import com.achd.mongo.Entity.BDT.BDT_Sub.BDT;
import com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub.*;
import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTA;
import com.achd.mongo.Entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class SomeUtil {

    private Random random = new Random();

    public BaseEntity randomPerson(int num) {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.set姓名("test"+String.valueOf(num));
        baseEntity.set编号(String.valueOf(num));
        baseEntity.set性别(random.nextInt(10) % 2 == 0 ? "男" : "女");

        ArrayList<BDT> bdts = new ArrayList<>();
        ArrayList<CCTA> cctas = new ArrayList<>();
//            BDT
        for (int i = 0; i < random.nextInt(3)+1; i++) {
            BDT bdt = new BDT();
            bdt.set年龄(random.nextInt(60)+10);
            bdt.set检查时间(new Date(random.nextInt(1573563765) + 1573563765));
            bdt.set心率(random.nextInt(100) + 70);
            bdt.set血压(String.valueOf(random.nextInt(50) + 150) + '/' + String.valueOf(random.nextInt(50) + 150));
            bdt.set身高(random.nextInt(100) + 100);
            bdt.set体重(random.nextInt(50) + 40);
            bdt.set检查目的(
                    new Purpose(
                            random.nextBoolean(),
                            random.nextBoolean(),
                            random.nextBoolean(),
                            random.nextBoolean(),
                            random.nextBoolean(),
                            String.valueOf(random.nextInt())));
            bdt.set高血压病(new Hypertension(random.nextInt(3) + 1, random.nextInt(4) + 1, random.nextInt(3) + 1));
            bdt.set血脂异常(new Dyslipidemia(random.nextInt(3)+1, random.nextInt(3)+1,random.nextInt(4)+1));
            bdt.set糖尿病史(new Diabetes(random.nextInt(3) + 1, random.nextInt(2) + 1, random.nextInt(4) + 1, random.nextInt(3) + 1));
            bdt.set外周血管病(new PeripheralVascularDisease(
                    random.nextInt(3) + 1,
                    String.valueOf(random.nextInt(2000)),
                    String.valueOf(random.nextInt()),
                    random.nextInt(2) + 1
            ));
            bdt.set吸烟史(new Smoking(
                    random.nextInt(3)+1,
                    random.nextInt(10),
                    random.nextInt(10),
                    random.nextInt(10),
                    random.nextInt(10)
            ));
            bdt.set饮酒史(new Drinking(
                    random.nextInt(4) + 1,
                    new Ps(new Liquor(random.nextInt(50), random.nextInt(200)), random.nextInt(100), random.nextInt(100), random.nextInt(100)),
                    random.nextInt(10)
            ));
            bdt.set体育锻炼史(new Exercise(random.nextInt(3) + 1, random.nextInt(2) + 1));
            bdt.set心肌梗死(new MyocardialInfarction(random.nextInt(2) + 1, String.valueOf(random.nextInt())));
            bdt.set目前服药(new Medication(random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), random.nextBoolean()));
            bdt.set其他疾病史(new OtherDisease(random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), String.valueOf(random.nextInt())));
            bdt.set家族史(new FamilyHistory(
                    new ACHD(random.nextInt(2) + 1, new Who(random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt())),
                    random.nextInt(2) + 1,
                    String.valueOf(random.nextInt())));
            bdts.add(bdt);
        }
//            CCTA
        for (int i = 0; i < random.nextInt(10)+1; i++) {
            CCTA ccta = new CCTA();
            ccta.set年龄(random.nextInt(60) + 10);
            ccta.set检查时间(new Date(random.nextInt(1573563765) + 1573563765));
            ccta.set冠状动脉CT是否异常(random.nextBoolean());
            ccta.set病变位置(random.nextInt(18) + 1);
            ccta.set病变长度(random.nextInt(3) + 1);
            ccta.set斑块特征(random.nextInt(3) + 1);
            ccta.set狭窄度(random.nextDouble());
            cctas.add(ccta);
        }

        baseEntity.setBDTs(bdts);
        baseEntity.setCCTAs(cctas);

//        System.out.println(baseEntity);
        return baseEntity;
    }


}
