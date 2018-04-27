package com.wams.wamsanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class WamsanagerApplication  {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        System.out.println("gl, hf");
        SpringApplication.run(WamsanagerApplication.class, args);


    }

}
