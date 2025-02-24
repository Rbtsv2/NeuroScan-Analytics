package com.neuroscan.repository;

import com.neuroscan.model.HealthData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthDataRepository extends JpaRepository<HealthData, Integer> {
}
