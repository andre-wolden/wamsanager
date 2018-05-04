package com.wams.wamsanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SensorType {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String sensorType;

    @OneToMany
    @JsonIgnore
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
