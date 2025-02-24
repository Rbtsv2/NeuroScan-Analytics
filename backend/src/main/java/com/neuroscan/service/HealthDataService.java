package com.neuroscan.service;

import com.neuroscan.model.HealthData;
import com.neuroscan.repository.HealthDataRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HealthDataService {

    private final HealthDataRepository healthDataRepository;

    public HealthDataService(HealthDataRepository healthDataRepository) {
        this.healthDataRepository = healthDataRepository;
    }

    public List<HealthData> getAllHealthData() {
        return healthDataRepository.findAll();
    }

    public HealthData createHealthData(HealthData healthData) {
        // Exemple de génération d'un identifiant à partir d'une valeur long
        // Assurez-vous que cette valeur est compatible avec la plage d'un Integer.
        long generatedId = System.currentTimeMillis();
        healthData.setPersonId((int) generatedId); // Cast explicite du long vers int
        return healthDataRepository.save(healthData);
    }
}
