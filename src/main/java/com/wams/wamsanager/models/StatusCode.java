package com.wams.wamsanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StatusCode {

    @Id
    @GeneratedValue
    private Long id;

    private Integer step;

    private String currentStatus;

    private String nextAction;

    @OneToMany
    Set<Sensor> sensors = new HashSet<>();

    public StatusCode() {
    }

    public StatusCode(Integer step, String currentStatus, String nextAction) {
        this.step = step;
        this.currentStatus = currentStatus;
        this.nextAction = nextAction;
    }

    public Long getId() {
        return id;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }
}
