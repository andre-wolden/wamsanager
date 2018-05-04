package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.LogItem;
import com.wams.wamsanager.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogItemRepo extends JpaRepository<LogItem, Long> {
    public List<LogItem> findBySensor(Sensor sensor);
}
