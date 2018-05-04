package com.wams.wamsanager.JsonModels;

public class JsonProject {

    private String name;
    private Long customerId;

    public JsonProject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
