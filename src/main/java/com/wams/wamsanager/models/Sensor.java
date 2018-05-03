package com.wams.wamsanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sensor {

    @Id
    @GeneratedValue
    private Long id;

    private String sn;

    private String calibrationCertificate;

    @ManyToOne
    @JsonIgnore
    private PartNumber partNumber;

    @ManyToOne
    @JsonIgnore
    private SensorType sensorType;

    @ManyToOne
    @JsonIgnore
    private Project project;

    @ManyToOne
    @JsonIgnore
    private StatusCode statusCode;

    @ManyToOne
    @JsonIgnore
    private MountingLocation mountingLocation;

    @OneToMany
    Set<LogItem> logItems = new HashSet<>();

    public Sensor() {
    }

    public Sensor(String sn
            , String calibrationCertificate
            , PartNumber partNumber
            , SensorType sensorType
            , Project project
            , StatusCode statusCode
            , MountingLocation mountingLocation) {
        this.sn = sn;
        this.calibrationCertificate = calibrationCertificate;
        this.partNumber = partNumber;
        this.sensorType = sensorType;
        this.project = project;
        this.statusCode = statusCode;
        this.mountingLocation = mountingLocation;
    }

    public Long getId() {
        return id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCalibrationCertificate() {
        return calibrationCertificate;
    }

    public void setCalibrationCertificate(String calibrationCertificate) {
        this.calibrationCertificate = calibrationCertificate;
    }

    public PartNumber getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(PartNumber partNumber) {
        this.partNumber = partNumber;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public MountingLocation getMountingLocation() {
        return mountingLocation;
    }

    public void setMountingLocation(MountingLocation mountingLocation) {
        this.mountingLocation = mountingLocation;
    }

    public Set<LogItem> getLogItems() {
        return logItems;
    }

    public void setLogItems(Set<LogItem> logItems) {
        this.logItems = logItems;
    }
}
