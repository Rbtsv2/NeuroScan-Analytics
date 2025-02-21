package com.neuroscan.service;

import com.neuroscan.model.HealthData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthDataService {

    private List<HealthData> healthDataList = new ArrayList<>();

    public List<HealthData> getAllHealthData() {
        return healthDataList;
    }

    public HealthData createHealthData(HealthData healthData) {
        healthData.setPersonId((long) (healthDataList.size() + 1));
        healthDataList.add(healthData);
        return healthData;
    }
}
