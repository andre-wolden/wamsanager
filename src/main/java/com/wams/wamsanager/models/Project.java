package com.wams.wamsanager.models;

public class Project {

    private long id;
    private String name;
    private Customer customer;

    public Project(String name, Customer customer){
        this.name = name;
        this.customer = customer;
    }



}
