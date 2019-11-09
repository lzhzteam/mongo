package com.achd.mongo.Entity;

import lombok.Data;

@Data
public class AnalyzeEntity {

    private Long testTrue;

    private Long testFalse;

    private Long testTotal;

    private Double testRate;

    private Long controlTrue;

    private Long controlFalse;

    private Long controlTotal;

    private Double controlRate;

    private String scale;

    // 相对危险度
    private  Double RR ;

    // 归隐危险度
    private  Double AR;

    // 人群归因危险度
    private Double PAR;

    private Long[] position;

    private Long[] length;

    private Long[] feature;

    public AnalyzeEntity(Long testTrue, Long testFalse, Long testTotal, Double testRate, Long controlTrue, Long controlFalse, Long controlTotal, Double controlRate, String scale, Double RR, Double AR, Double PAR, Long[] position, Long[] length, Long[] feature) {
        this.testTrue = testTrue;
        this.testFalse = testFalse;
        this.testTotal = testTotal;
        this.testRate = testRate;
        this.controlTrue = controlTrue;
        this.controlFalse = controlFalse;
        this.controlTotal = controlTotal;
        this.controlRate = controlRate;
        this.scale = scale;
        this.RR = RR;
        this.AR = AR;
        this.PAR = PAR;
        this.position = position;
        this.length = length;
        this.feature = feature;
    }
}
