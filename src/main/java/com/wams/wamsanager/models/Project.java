package com.wams.wamsanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    public Project() {

    }

    public Project(String name) {
        this.name = name;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public long getCustomerId(){
        return this.customer.getId();
    }
}
