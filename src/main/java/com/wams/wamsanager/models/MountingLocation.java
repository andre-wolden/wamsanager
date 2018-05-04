package com.wams.wamsanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MountingLocation {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String mountingLocation;

    @OneToMany
    @JsonIgnore
    Set<Sensor> sensors = new HashSet<>();

    public MountingLocation() {
    }

    public MountingLocation(String mountingLocation) {
        this.mountingLocation = mountingLocation;
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

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }
}
