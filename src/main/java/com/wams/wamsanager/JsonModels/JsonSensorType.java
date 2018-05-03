package com.wams.wamsanager.JsonModels;

public class JsonSensorType {

    private String sensorType;

    public JsonSensorType() {
    }

    public JsonSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
}
