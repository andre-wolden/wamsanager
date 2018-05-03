package com.wams.wamsanager.JsonModels;

public class JsonStatusCode {

    private Long id;
    private Integer step;
    private String currentStatus;
    private String nextAction;

    public JsonStatusCode() {
    }

    public JsonStatusCode(Long id, Integer step, String currentStatus, String nextAction) {
        this.id = id;
        this.step = step;
        this.currentStatus = currentStatus;
        this.nextAction = nextAction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
