package com.neuroscan.controller;

import com.neuroscan.model.HealthData;
import com.neuroscan.service.HealthDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Autorise toutes les origines
@RestController
@RequestMapping("/api/health")
public class HealthDataController {

    private final HealthDataService healthDataService;

    public HealthDataController(HealthDataService healthDataService) {
        this.healthDataService = healthDataService;
    }

    @GetMapping
    public List<HealthData> getAllHealthData() {
        return healthDataService.getAllHealthData();
    }

    @PostMapping
    public HealthData createHealthData(@RequestBody HealthData healthData) {
        return healthDataService.createHealthData(healthData);
    }
}
