package com.itla.university.model.entity;

public class Career extends Entity{

    private static final String DESCRIPTION = Career.class.getCanonicalName();

    private Integer id;
    private String name;
    private Integer asignatures;
    private Integer credits;

    public Career() {
        super(DESCRIPTION);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAsignatures() {
        return asignatures;
    }

    public void setAsignatures(Integer asignatures) {
        this.asignatures = asignatures;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
