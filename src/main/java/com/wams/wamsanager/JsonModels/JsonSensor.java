package com.wams.wamsanager.JsonModels;

public class JsonSensor {

    private String sn;
    private String calibrationCertificate;
    private Long partNumberId;
    private Long sensorTypeId;
    private Long projectId;
    private Long statusCodeId;
    private Long mountingLocationId;

    public JsonSensor() {
    }

    public JsonSensor(String sn){
        this.sn = sn;
    }

    public JsonSensor(String sn,
                      String calibrationCertificate,
                      Long partNumberId,
                      Long sensorTypeId,
                      Long projectId,
                      Long statusCodeId,
                      Long mountingLocationId) {
        this.sn = sn;
        this.calibrationCertificate = calibrationCertificate;
        this.partNumberId = partNumberId;
        this.sensorTypeId = sensorTypeId;
        this.projectId = projectId;
        this.statusCodeId = statusCodeId;
        this.mountingLocationId = mountingLocationId;
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

    public Long getPartNumberId() {
        return partNumberId;
    }

    public void setPartNumberId(Long partNumberId) {
        this.partNumberId = partNumberId;
    }

    public Long getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(Long sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getStatusCodeId() {
        return statusCodeId;
    }

    public void setStatusCodeId(Long statusCodeId) {
        this.statusCodeId = statusCodeId;
    }

    public Long getMountingLocationId() {
        return mountingLocationId;
    }

    public void setMountingLocationId(Long mountingLocationId) {
        this.mountingLocationId = mountingLocationId;
    }
}
