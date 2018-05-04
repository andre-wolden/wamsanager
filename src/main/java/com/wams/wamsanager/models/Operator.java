package com.wams.wamsanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Operator {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany
    @JsonIgnore
    private Set<LogItem> logItems = new HashSet<>();

    public Operator() {
    }

    public Operator(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LogItem> getLogItems() {
        return logItems;
    }

    public void setLogItems(Set<LogItem> logItems) {
        this.logItems = logItems;
    }
}
