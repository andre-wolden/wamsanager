package com.wams.wamsanager.controllers;

import com.wams.wamsanager.JsonModels.JsonSensorType;
import com.wams.wamsanager.models.SensorType;
import com.wams.wamsanager.repositories.SensorTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sensor_types")
public class SensorTypeController {

    @Autowired
    SensorTypeRepo sensorTypeRepo;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SensorType> all(){
        return sensorTypeRepo.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addSensorType(@RequestBody JsonSensorType newSensorType){
        sensorTypeRepo.save(new SensorType(newSensorType.getSensorType()));
        return "New Sensor Type added successfully...";
    }

    @RequestMapping(value = "/{sensorTypeId}", method = RequestMethod.GET)
    public SensorType getSensorTypeById(@PathVariable Long sensorTypeId){
        return sensorTypeRepo.findById(sensorTypeId).orElse(new SensorType());
    }

    @RequestMapping(value = "/{sensorTypeId}/update", method = RequestMethod.PATCH)
    public String updateSensorType(@PathVariable Long sensorTypeId, @RequestBody JsonSensorType jsonSensorType){
        SensorType sensorTypeToUpdate = sensorTypeRepo.getOne(sensorTypeId);
        sensorTypeToUpdate.setSensorType(jsonSensorType.getSensorType());
        sensorTypeRepo.save(sensorTypeToUpdate);
        return "Sensor Type successfully updated";
    }

    @RequestMapping(value = "/{sensorTypeId}/delete", method = RequestMethod.DELETE)
    public String deleteSensorType(@PathVariable Long sensorTypeId){
        sensorTypeRepo.deleteById(sensorTypeId);
        return "Sensor type successfully deleted";
    }
}
