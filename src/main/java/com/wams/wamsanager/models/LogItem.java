package com.wams.wamsanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class LogItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String logMessage;

    @ManyToOne
    @JsonIgnore
    private Sensor sensor;

    @ManyToOne
    private Operator operator;

    public LogItem() {
    }

    public LogItem(Sensor sensor, Operator operator, String logMessage) {
        this.sensor = sensor;
        this.operator = operator;
        this.logMessage = logMessage;
    }

    public Long getId() {
        return id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }


}
