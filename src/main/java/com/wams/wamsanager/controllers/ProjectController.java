package com.wams.wamsanager.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wams.wamsanager.models.Customer;
import com.wams.wamsanager.models.Project;
import com.wams.wamsanager.repositories.CustomerRepo;
import com.wams.wamsanager.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    ProjectRepo projectRepo;
    CustomerRepo customerRepo;

    @RequestMapping(value = "/new" ,method = RequestMethod.POST)
    public String projectsRoot(@RequestBody String input) throws IOException {

        List<Customer> allCustomers = customerRepo.findAll();
        Customer customer = allCustomers.get(0);

        Project newProject = new Project();

        newProject.setName("Plan B");
        newProject.setCustomer(customer);


        projectRepo.save(newProject);

        return String.format("Saved successfully: %s", newProject.toString());

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllProjects() throws JsonProcessingException {
        List<Project> allProjects = projectRepo.findAll();

        Project project = allProjects.get(1);

        ObjectMapper mapper = new ObjectMapper();

        String s = mapper.writeValueAsString(project);

        return s;
    }
}
