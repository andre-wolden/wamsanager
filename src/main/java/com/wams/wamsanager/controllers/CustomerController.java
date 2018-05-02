package com.wams.wamsanager.controllers;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wams.wamsanager.models.Customer;
import com.wams.wamsanager.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @RequestMapping(value = "/all", produces = "application/json")
    public String customersRoot() throws JsonProcessingException {

        List<Customer> all = customerRepo.findAll();

        Customer bekk = all.get(1);


        ObjectMapper mapper = new ObjectMapper();

        String s = mapper.writeValueAsString(bekk);

        return s;
    }

    @RequestMapping("/new")
    public String newCustomer(){

        Customer customer = new Customer();
        customer.setName("Statoil");

        customerRepo.save(customer);

        return "My life, for Aiur  /n" + "New Customer registered.";
    }

}
