package com.wams.wamsanager.controllers;

import com.wams.wamsanager.models.LogItem;
import com.wams.wamsanager.repositories.LogItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/log_items")
public class LogItemController {

    @Autowired
    LogItemRepo logItemRepo;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<LogItem> allLogItems(){
        return logItemRepo.findAll();
    }

}
