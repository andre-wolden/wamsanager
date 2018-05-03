package com.wams.wamsanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class LogItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Sensor sensor;

    @ManyToOne
    @JsonIgnore
    private Operator operator;

    public LogItem() {
    }

    public LogItem(Sensor sensor, Operator operator) {
        this.sensor = sensor;
        this.operator = operator;
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
}
