package com.itla.university.model.entity;

public class Student extends Entity{

    private static final String DESCRIPTION = Student.class.getCanonicalName();

    private Integer id;
    private String name;
    private String registration;
    private Integer career_id;

    public Student() {
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
