package com.wams.wamsanager.controllers;

import com.wams.wamsanager.models.Customer;
import com.wams.wamsanager.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    CustomerRepo customerRepo;

    @RequestMapping(value = "/")
    public String projectsRoot(){
      return "projects root path";
    }

    @RequestMapping(name = "/all", method = RequestMethod.GET)
    public String getAllProjects(){
        List<Customer> allProjects = customerRepo.findAll();

        System.out.println(allProjects);

        return allProjects.toString();
    }
}
