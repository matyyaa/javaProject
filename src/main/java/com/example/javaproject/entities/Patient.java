package com.example.javaproject.entities;

import java.util.Date;

public class Patient {

    private int id;
    private String name;
    private Date birthday;
    private String diagnosis;
    private int doctor_id;
    private boolean status;

    public Patient(int id, String name, Date birthday, String diagnosis, int doctor_id, boolean status) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.diagnosis = diagnosis;
        this.doctor_id = doctor_id;
        this.status = status;
    }

    public Patient(String name, Date birthday, String diagnosis, int doctor_id, boolean status) {
        this.name = name;
        this.birthday = birthday;
        this.diagnosis = diagnosis;
        this.doctor_id = doctor_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
