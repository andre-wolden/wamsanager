package com.wams.wamsanager.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wams.wamsanager.models.TestResource;
import com.wams.wamsanager.repositories.TestResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/test_resource")
public class TestResourceController {

    @Autowired
    TestResourceRepo testResourceRepo;

    @RequestMapping("/new")
    public String newTestResource(){

        TestResource testResource = new TestResource();

        testResource.setFirstName("André");
        testResource.setLastName("Wolden");
        testResource.setEmail("andre.wolden@hotmail.com");

        testResourceRepo.save(testResource);

        return String.format("Registered successfully. first name: %s, last name: %s, email: %s",
                        testResource.getFirstName(), testResource.getLastName(), testResource.getEmail());
    }

    @RequestMapping("/all")
    public String all() throws JsonProcessingException {

        List<TestResource> all = testResourceRepo.findAll();

        TestResource testResource = all.get(0);

        ObjectMapper mapper = new ObjectMapper();

        String string = mapper.writeValueAsString(testResource);

        return string;
    }

}
