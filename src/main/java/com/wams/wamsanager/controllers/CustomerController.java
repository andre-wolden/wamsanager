package com.wams.wamsanager.controllers;


import com.fasterxml.jackson.core.JsonGenerationException;
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

    @RequestMapping("/")
    public String customersRoot(){
      return "Customers Root"
    }

    @RequestMapping("/new")
    public String newCustomer(){
        return "Funker hot reloading? ved å trykke build i IntelliJ?";
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllCustomers(){

        List<Customer> customers = customerRepo.findAll();

//        ObjectMapper mapper = new ObjectMapper();

//        try{
//            mapper.writeValue(new File("/Users/andre.wolden/coding/egne/wamsanager/afroman.json"), customer);
//
//        } catch (JsonGenerationException error) {
//            return "JsonGenerationException" + error.toString();
//        } catch (JsonMappingException error){
//            return "JsonMappingException" + error.toString();
//        } catch (IOException error){
//            return "IOException" + error.toString();
//        }

        return customers.toString();
    }




}
