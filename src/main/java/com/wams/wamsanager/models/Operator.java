package com.wams.wamsanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Operator {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany
    Set<LogItem> logItems = new HashSet<>();

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
