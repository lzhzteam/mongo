package com.achd.mongo.Entity.CCTA.CCTA_Sub;

public class CCTAs {
    private Integer age;
    private String no;
    private Boolean coronaryArtery;
    private Integer position;
    private Integer length;
    private Integer plaque;
    private Double Stenosis;

    public CCTAs() {
    }

    public CCTAs(Integer age, String no, Boolean coronaryArtery, Integer position, Integer length, Integer plaque, Double stenosis) {
        this.age = age;
        this.no = no;
        this.coronaryArtery = coronaryArtery;
        this.position = position;
        this.length = length;
        this.plaque = plaque;
        Stenosis = stenosis;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Boolean getCoronaryArtery() {
        return coronaryArtery;
    }

    public void setCoronaryArtery(Boolean coronaryArtery) {
        this.coronaryArtery = coronaryArtery;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPlaque() {
        return plaque;
    }

    public void setPlaque(Integer plaque) {
        this.plaque = plaque;
    }

    public Double getStenosis() {
        return Stenosis;
    }

    public void setStenosis(Double stenosis) {
        Stenosis = stenosis;
    }
}
