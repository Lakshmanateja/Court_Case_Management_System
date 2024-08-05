package com.example.courtcasemanagementsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cases")
public class CaseDetails {

    private String name;
    private int age;
    private String dob;
    private String gender;
    private String address;

    @Id
    private int caseId;
    private String caseType;
    private int courtId;
    private String date;
    private boolean status;
    private int numberOfDays;
    private String description;

    @Override
    public String toString() {
        return "CaseDetails{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", caseId=" + caseId +
                ", caseType='" + caseType + '\'' +
                ", courtId=" + courtId +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", numberOfDays=" + numberOfDays +
                ", description='" + description + '\'' +
                '}';
    }

    public CaseDetails(int age, String name, String dob, String gender, String address, int caseId, String caseType, int courtId, String date, boolean status, int numberOfDays, String description) {
        this.age = age;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.caseId = caseId;
        this.caseType = caseType;
        this.courtId = courtId;
        this.date = date;
        this.status = status;
        this.numberOfDays = numberOfDays;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
