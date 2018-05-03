package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorTypeRepo extends JpaRepository<SensorType, Long> {
}
