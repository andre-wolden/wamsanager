package com.wams.wamsanager.models;


import java.util.List;

public class Customer {

    private long id;
    private String name;
    private List<Project> projects;


    public Customer(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format(
                "Customer[id=%d, name='%s']",
                id, name
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean addProject(Project project){
        projects.add(project);

        return true;

    }
}
