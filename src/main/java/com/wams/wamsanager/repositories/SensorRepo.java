package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepo extends JpaRepository<Sensor, Long> {
    Sensor findBySn(String sn);
}
