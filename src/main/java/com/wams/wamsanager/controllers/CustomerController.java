package com.wams.wamsanager.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.wams.wamsanager.JsonModels.JsonCustomer;
import com.wams.wamsanager.models.Customer;
import com.wams.wamsanager.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @RequestMapping(value = "/all", method = RequestMethod.GET , produces = "application/json")
    public List<Customer> allCustomers() {

        return customerRepo.findAll();
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable Long customerId){
        return customerRepo.findById(customerId).orElse(new Customer());
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addCustomer(@RequestBody JsonCustomer jsonCustomer){

        customerRepo.save(new Customer(jsonCustomer.getName()));

        return "New customer registrated...";
    }

}
