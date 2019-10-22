package com.itla.university.model.entity;

public class Asignature extends Entity{

    private static final String DESCRIPTION = Asignature.class.getCanonicalName();

    private Integer id;
    private String name;
    private Integer credits;

    public Asignature() {
        super(DESCRIPTION);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
