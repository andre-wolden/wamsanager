package com.wams.wamsanager.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public CustomerController(){

    }


    @RequestMapping("/test")
    public String customers(){
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS customers " +
                "(id SERIAL PRIMARY KEY, " +
                "name TEXT NOT NULL);");


        jdbcTemplate.execute("INSERT INTO customers (name) VALUES ('BYGGMAKKER');");


        return "customer successfully saved";
    }



}
