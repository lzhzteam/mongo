package com.achd.mongo.Entity;

import lombok.Data;

@Data
public class AnalyzeEntity {

    private Long testTrue;

    private Long testFalse;

    private Long controlTrue;

    private Long controlFalse;

    private Long[] position;

    private Long[] length;

    private Long[] feature;

    public AnalyzeEntity(Long testTrue, Long testFalse, Long controlTrue, Long controlFalse, Long[] position, Long[] length, Long[] feature) {
        this.testTrue = testTrue;
        this.testFalse = testFalse;
        this.controlTrue = controlTrue;
        this.controlFalse = controlFalse;
        this.position = position;
        this.length = length;
        this.feature = feature;
    }
}
