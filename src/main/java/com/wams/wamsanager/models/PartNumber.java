package com.wams.wamsanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PartNumber {

    @Id
    @GeneratedValue
    private Long id;

    private String pn;

    private String calibrationProcedure;

    @OneToMany
    Set<Sensor> sensors = new HashSet<>();

    public PartNumber() {
    }

    public PartNumber(String pn, String calibrationProcedure) {
        this.pn = pn;
        this.calibrationProcedure = calibrationProcedure;
    }

    public Long getId() {
        return id;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getCalibrationProcedure() {
        return calibrationProcedure;
    }

    public void setCalibrationProcedure(String calibrationProcedure) {
        this.calibrationProcedure = calibrationProcedure;
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }
}
