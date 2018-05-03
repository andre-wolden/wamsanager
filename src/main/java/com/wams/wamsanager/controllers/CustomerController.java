package com.wams.wamsanager.controllers;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wams.wamsanager.models.Customer;
import com.wams.wamsanager.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @RequestMapping(value = "/all", produces = "application/json")
    public Collection<Customer> allCustomers() throws JsonProcessingException {

        return customerRepo.findAll();
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable Long customerId){
        return customerRepo.findById(customerId).orElse(new Customer());
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addCustomer(@RequestBody Customer input_customer){

        Customer customer = input_customer;

        customerRepo.save(customer);

        return "New customer registrated...";
    }

}
