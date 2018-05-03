package com.wams.wamsanager.controllers;

import com.wams.wamsanager.JsonModels.JsonPartNumber;
import com.wams.wamsanager.models.PartNumber;
import com.wams.wamsanager.repositories.PartNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/part_numbers")
public class PartNumberController {

    @Autowired
    PartNumberRepo partNumberRepo;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<PartNumber> allPartNumbers(){
        return partNumberRepo.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPartNumber(@RequestBody JsonPartNumber jsonPartNumber){
        partNumberRepo.save(new PartNumber(jsonPartNumber.getPn(), jsonPartNumber.getCalibrationProcedure()));
        return "Part Number successfully added...";
    }

    @RequestMapping(value = "/{partNumberId}", method = RequestMethod.GET)
    public PartNumber getPartNumberById(@PathVariable Long partNumberId){
        return partNumberRepo.getOne(partNumberId);
    }

    @RequestMapping(value = "/{partNumberId}/update", method = RequestMethod.PATCH)
    public String updatePartNumber(@PathVariable Long partNumberId, @RequestBody JsonPartNumber jsonPartNumber){
        PartNumber partNumberToUpdate = partNumberRepo.getOne(partNumberId);
        partNumberToUpdate.setPn(jsonPartNumber.getPn());
        partNumberToUpdate.setCalibrationProcedure(jsonPartNumber.getCalibrationProcedure());
        partNumberRepo.save(partNumberToUpdate);
        return "Part Number successfully updated";
    }

    @RequestMapping(value = "/{partNumberId/delete}", method = RequestMethod.DELETE)
    public String deletePartNumber(@PathVariable Long partNumberId){
        partNumberRepo.deleteById(partNumberId);
        return "Part Number successfully deleted";
    }
}
