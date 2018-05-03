package com.wams.wamsanager.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany
    private Set<Project> projects = new HashSet<>();

    public Customer() {
    }

    public Customer(String name, Set<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
