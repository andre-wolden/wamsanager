package com.wams.wamsanager.controllers;

import com.wams.wamsanager.JsonModels.JsonOperator;
import com.wams.wamsanager.models.Operator;
import com.wams.wamsanager.repositories.OperatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/operators")
public class OperatorController {

    @Autowired
    OperatorRepo operatorRepo;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Operator> allOperators(){
        return operatorRepo.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addOperator(@RequestBody JsonOperator jsonOperator){
        operatorRepo.save(new Operator(jsonOperator.getName()));
        return "Operator successfully saved";
    }

    @RequestMapping(value = "/{operatorId}", method = RequestMethod.GET)
    public Operator getOperatorById(@PathVariable Long operatorId){
        return operatorRepo.getOne(operatorId);
    }

    @RequestMapping(value = "/{operatorId}/update", method = RequestMethod.PATCH)
    public String updateOperator(@PathVariable Long operatorId, @RequestBody JsonOperator jsonOperator){
        Operator operatorToUpdate = operatorRepo.getOne(operatorId);
        operatorToUpdate.setName(jsonOperator.getName());
        operatorRepo.save(operatorToUpdate);
        return "Operator successfully updated";
    }

    @RequestMapping(value = "/{operatorId}/delete", method = RequestMethod.DELETE)
    public String deleteOperator(@PathVariable Long operatorId){
        operatorRepo.deleteById(operatorId);
        return "Operator successfully deleted";
    }

}
