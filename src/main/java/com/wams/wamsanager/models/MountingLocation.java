package com.wams.wamsanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MountingLocation {

    @Id
    @GeneratedValue
    private Long id;

    private String mountingLocation;

    @OneToMany
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
}
