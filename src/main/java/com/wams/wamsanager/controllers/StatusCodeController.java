package com.wams.wamsanager.controllers;

import com.wams.wamsanager.JsonModels.JsonStatusCode;
import com.wams.wamsanager.models.StatusCode;
import com.wams.wamsanager.repositories.StatusCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/status_codes")
public class StatusCodeController {

    @Autowired
    StatusCodeRepo statusCodeRepo;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<StatusCode> getStatusCodes(){
        return statusCodeRepo.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addStatusCode(@RequestBody JsonStatusCode jsonStatusCode){
        statusCodeRepo.save(new StatusCode(jsonStatusCode.getStep()
                , jsonStatusCode.getCurrentStatus()
                , jsonStatusCode.getNextAction()));

        return "Status Code successfully added";
    }

    @RequestMapping(value = "/{statusCodeId}", method = RequestMethod.GET)
    public StatusCode getStatusCodeById(@PathVariable Long statusCodeId){
        return statusCodeRepo.findById(statusCodeId).orElse(new StatusCode());
    }

    @RequestMapping(value = "/{statusCodeId}/update", method = RequestMethod.PATCH)
    public String updateStatusCode(@PathVariable Long statusCodeId, @RequestBody JsonStatusCode jsonStatusCode){
        StatusCode statusCodeToUpdate = statusCodeRepo.getOne(statusCodeId);
        statusCodeToUpdate.setStep(jsonStatusCode.getStep());
        statusCodeToUpdate.setCurrentStatus(jsonStatusCode.getCurrentStatus());
        statusCodeToUpdate.setNextAction(jsonStatusCode.getNextAction());
        statusCodeRepo.save(statusCodeToUpdate);

        return "Status Code successfully updated";
    }

    @RequestMapping(value = "/{statusCodeId}/delete", method = RequestMethod.DELETE)
    public String deleteStatusCode(@PathVariable Long statusCodeId){
        statusCodeRepo.deleteById(statusCodeId);
        return "Status Code successfully deleted";
    }

}
