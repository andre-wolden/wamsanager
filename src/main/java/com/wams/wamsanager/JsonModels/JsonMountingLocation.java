package com.wams.wamsanager.JsonModels;

public class JsonMountingLocation {

    private Long id;
    private String mountingLocation;

    public JsonMountingLocation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMountingLocation() {
        return mountingLocation;
    }

    public void setMountingLocation(String mountingLocation) {
        this.mountingLocation = mountingLocation;
    }
}
