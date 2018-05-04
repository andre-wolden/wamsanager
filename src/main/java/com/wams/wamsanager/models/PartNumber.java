package com.wams.wamsanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PartNumber {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String pn;

    @Column
    private String calibrationProcedure;

    @OneToMany
    @JsonIgnore
    private Set<Sensor> sensors = new HashSet<>();

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
