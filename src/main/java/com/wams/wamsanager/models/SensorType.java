package com.wams.wamsanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SensorType {

    @Id
    @GeneratedValue
    private Long id;

    private String sensorType;

    @OneToMany
    Set<Sensor> sensors = new HashSet<>();

    public SensorType() {
    }

    public SensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Long getId() {
        return id;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }
}
