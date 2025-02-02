package com.neuroscan.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "health_data")
public class HealthData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private String gender;
    private int age;
    private String occupation;
    private double sleepDuration;
    private int sleepQuality;
    private int physicalActivityLevel;
    private int stressLevel;
    private String bmiCategory;
    private String bloodPressure;
    private int heartRate;
    private int dailySteps;
    private String sleepDisorder;
}
