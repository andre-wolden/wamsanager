package com.wams.wamsanager.controllers;

import com.wams.wamsanager.JsonModels.JsonProject;
import com.wams.wamsanager.models.Customer;
import com.wams.wamsanager.models.Project;
import com.wams.wamsanager.repositories.CustomerRepo;
import com.wams.wamsanager.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    CustomerRepo customerRepo;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Project> allProjects() {
        return projectRepo.findAll();
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public Project getProjectById(@PathVariable Long projectId){
        return projectRepo.findById(projectId)
                .orElse(new Project());
    }

    @RequestMapping(value = "/new" ,method = RequestMethod.POST)
    public String addProject(@RequestBody JsonProject jsonProject)  {

        projectRepo.save(new Project(jsonProject.getName()));

        return "Project successfully saved";


//        return this.customerRepo.findById(jsonProject.getCustomerId())
//                .map(customer -> {
//                    projectRepo.save(new Project(jsonProject.getName()));
//                    return "Project added successfully...";
//                }).orElse("Oops. Something went wrong..");
    }

    @RequestMapping(value = "{projectId}/update", method = RequestMethod.PATCH)
    public String updateProject(@PathVariable long projectId, @RequestBody JsonProject jsonProject){

        Project projectToUpdate = projectRepo.getOne(projectId);
        projectToUpdate.setName(jsonProject.getName());
        Customer customer = customerRepo.getOne(jsonProject.getCustomerId());
        projectToUpdate.setCustomer(customer);
        projectRepo.save(projectToUpdate);

        return "project successfully updated...";
    }

    @RequestMapping(value = "{projectId}/updateCustomer", method = RequestMethod.PATCH)
    public String updateCustomer(@PathVariable Long projectId, @RequestBody JsonProject jsonProject){
        Project projectToUpdate = projectRepo.getOne(projectId);
        Customer customer = customerRepo.getOne(jsonProject.getCustomerId());
        projectToUpdate.setCustomer(customer);
        projectRepo.save(projectToUpdate);

        return String.format("Customer registered for project %s", projectToUpdate.getName());
    }
}
