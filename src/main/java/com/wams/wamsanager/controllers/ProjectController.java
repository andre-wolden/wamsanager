package com.wams.wamsanager.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wams.wamsanager.models.Customer;
import com.wams.wamsanager.models.Project;
import com.wams.wamsanager.repositories.CustomerRepo;
import com.wams.wamsanager.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers/{customerId}/projects")
public class ProjectController {

    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    CustomerRepo customerRepo;

    @RequestMapping(value = "/new" ,method = RequestMethod.POST)
    public String projectsRoot(@PathVariable String customerId, @RequestBody Project input) throws IOException {


        return this.customerRepo.findById(Long.parseLong(customerId))
                .map(customer -> {
                    Project new_project = projectRepo.save(new Project(input.getName(), customer));
                    System.out.println("New Project added");
                    return "ksadjfn";
                }).orElse("asjfn");
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
