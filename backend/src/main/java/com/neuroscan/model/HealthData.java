package com.neuroscan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "health_data")
public class HealthData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;
    
    private String gender;
    private Integer age;
    private String occupation;
    private Double sleepDuration;
    
    // Spécifiez que ce champ est mappé à la colonne "sleep_quality" dans la table
    @Column(name = "sleep_quality", nullable = false)
    private Integer qualityOfSleep;
    
    private Integer physicalActivityLevel;
    private Integer stressLevel;
    private String bmiCategory;
    private String bloodPressure;
    private Integer heartRate;
    private Integer dailySteps;
    private String sleepDisorder;

    // Constructeur par défaut
    public HealthData() {
    }

    // Getters et setters

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(Double sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    public Integer getQualityOfSleep() {
        return qualityOfSleep;
    }

    public void setQualityOfSleep(Integer qualityOfSleep) {
        this.qualityOfSleep = qualityOfSleep;
    }

    public Integer getPhysicalActivityLevel() {
        return physicalActivityLevel;
    }

    public void setPhysicalActivityLevel(Integer physicalActivityLevel) {
        this.physicalActivityLevel = physicalActivityLevel;
    }

    public Integer getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(Integer stressLevel) {
        this.stressLevel = stressLevel;
    }

    public String getBmiCategory() {
        return bmiCategory;
    }

    public void setBmiCategory(String bmiCategory) {
        this.bmiCategory = bmiCategory;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getDailySteps() {
        return dailySteps;
    }

    public void setDailySteps(Integer dailySteps) {
        this.dailySteps = dailySteps;
    }

    public String getSleepDisorder() {
        return sleepDisorder;
    }

    public void setSleepDisorder(String sleepDisorder) {
        this.sleepDisorder = sleepDisorder;
    }
}
