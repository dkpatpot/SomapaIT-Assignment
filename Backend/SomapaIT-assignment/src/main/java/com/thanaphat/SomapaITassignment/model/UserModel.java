package com.thanaphat.SomapaITassignment.model;

import com.opencsv.bean.CsvBindByName;

public class UserModel {
    @CsvBindByName(column = "First name")
    private String firstname;
    @CsvBindByName(column = "Last name")
    private String lastname;
    @CsvBindByName(column = "Gender")
    private String gender;
    @CsvBindByName(column = "Date of birth")
    private String birthdate;
    @CsvBindByName(column = "Nationality")
    private String nationality;
    

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
