package com.itla.university.model.entity;

public class CareerAsignature {

    private Integer career_id;
    private Integer asignature_id;

    public CareerAsignature(Integer career_id, Integer asignature_id) {
        this.career_id = career_id;
        this.asignature_id = asignature_id;
    }

    public Integer getCareer_id() {
        return career_id;
    }

    public void setCareer_id(Integer career_id) {
        this.career_id = career_id;
    }

    public Integer getAsignature_id() {
        return asignature_id;
    }

    public void setAsignature_id(Integer asignature_id) {
        this.asignature_id = asignature_id;
    }
}
