package com.wams.wamsanager.controllers;

import com.wams.wamsanager.JsonModels.JsonSensor;
import com.wams.wamsanager.models.LogItem;
import com.wams.wamsanager.models.Operator;
import com.wams.wamsanager.models.Sensor;
import com.wams.wamsanager.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sensors")
public class SensorController {

    @Autowired
    SensorRepo sensorRepo;
    @Autowired
    PartNumberRepo partNumberRepo;
    @Autowired
    SensorTypeRepo sensorTypeRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    StatusCodeRepo statusCodeRepo;
    @Autowired
    MountingLocationRepo mountingLocationRepo;
    @Autowired
    LogItemRepo logItemRepo;
    @Autowired
    OperatorRepo operatorRepo;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Sensor> allSensors(){
        return sensorRepo.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addSensor(@RequestBody JsonSensor jsonSensor){

        List<Operator> operators = operatorRepo.findAll();
        Operator operator = operators.get(0);

        List<Sensor> sensors = sensorRepo.findAll();

        for (Sensor sensor : sensors){
            if (sensor.getSn().equals(jsonSensor.getSn())){
                return "Invalid serial number. It already exists";
            }
        }

        Sensor newSensor = new Sensor(jsonSensor.getSn());

        sensorRepo.save(newSensor);

        Sensor savedSensor = sensorRepo.findBySn(newSensor.getSn());

        String logMessage = String.format("New sensor with SN: %s was created by operator: %s.",
                savedSensor.getSn(),
                operator.getName());

        LogItem logItem = new LogItem(savedSensor, operator, logMessage);
        logItemRepo.save(logItem);

        return "Sensor successfully saved..";
    }

    @RequestMapping(value = "/{sensorId}", method = RequestMethod.GET)
    public Sensor getSensorById(@PathVariable Long sensorId){
        return sensorRepo.getOne(sensorId);
    }

    @RequestMapping(value = "/{sensorId}/update", method = RequestMethod.PATCH)
    public String updateSensor(@PathVariable Long sensorId, @RequestBody JsonSensor jsonSensor){
        Sensor sensorToUpdate = sensorRepo.getOne(sensorId);

        sensorToUpdate.setSn(jsonSensor.getSn());
        sensorToUpdate.setCalibrationCertificate(jsonSensor.getCalibrationCertificate());
        sensorToUpdate.setSensorType(sensorTypeRepo.getOne(jsonSensor.getSensorTypeId()));
        sensorToUpdate.setPartNumber(partNumberRepo.getOne(jsonSensor.getPartNumberId()));
        sensorToUpdate.setProject(projectRepo.getOne(jsonSensor.getProjectId()));
        sensorToUpdate.setStatusCode(statusCodeRepo.getOne(jsonSensor.getStatusCodeId()));
        sensorToUpdate.setMountingLocation(mountingLocationRepo.getOne(jsonSensor.getMountingLocationId()));

        List<Operator> operators = operatorRepo.findAll();
        Operator operator = operators.get(0);

        String logMessage = String.format("Sensor with SN: %s was updated by operator: %s.",
                sensorToUpdate.getSn(),
                operator.getName());

        LogItem logItem = new LogItem(sensorToUpdate, operator, logMessage);
        logItemRepo.save(logItem);


        return "Successfully updated sensor";
    }

    @RequestMapping(value = "/{sensorId}/updateCalibrationCertificate", method = RequestMethod.PATCH)
    public String updateCalibrationCertificate(@PathVariable Long sensorId, @RequestBody JsonSensor input){

        Sensor sensorToUpdate = sensorRepo.getOne(sensorId);

        if (sensorToUpdate.getStatusCode().getStep().equals(4)){

            sensorToUpdate.setCalibrationCertificate(input.getCalibrationCertificate());
            sensorRepo.save(sensorToUpdate);
            String calibrationCertificateDocNumber = sensorToUpdate.getPartNumber().getPn();

            List<Operator> operators = operatorRepo.findAll();
            Operator operator = operators.get(0);
            String logMessage = String.format("Sensor with SN: %s was updated by operator: %s. " +
                            "Calibration Certificate registered: %s.",
                    sensorToUpdate.getSn(),
                    operator.getName(),
                    calibrationCertificateDocNumber
            );
            LogItem logItem = new LogItem(sensorToUpdate, operator, logMessage);
            logItemRepo.save(logItem);

            return "Successfully registered calibration certificate";

        } else {

            return "Successfully updated sensor : part number";
        }
    }

    @RequestMapping(value = "/{sensorId}/updatePartNumber", method = RequestMethod.PATCH)
    public String updatePartNumber(@PathVariable Long sensorId, @RequestBody JsonSensor input){

        Sensor sensorToUpdate = sensorRepo.getOne(sensorId);
        String oldPartNumber = sensorToUpdate.getPartNumber().getPn();
        sensorToUpdate.setPartNumber(partNumberRepo.getOne(input.getPartNumberId()));
        sensorRepo.save(sensorToUpdate);
        String newPartNumber = sensorToUpdate.getPartNumber().getPn();

        List<Operator> operators = operatorRepo.findAll();
        Operator operator = operators.get(0);
        String logMessage = String.format("Sensor with SN: %s was updated by operator: %s. Partnumber changed from %s to %s.",
                sensorToUpdate.getSn(),
                operator.getName(),
                oldPartNumber,
                newPartNumber);
        LogItem logItem = new LogItem(sensorToUpdate, operator, logMessage);
        logItemRepo.save(logItem);

        return "Successfully updated sensor : part number";
    }

    @RequestMapping(value = "/{sensorId}/updateSensorType", method = RequestMethod.PATCH)
    public String updateSensorType(@PathVariable Long sensorId, @RequestBody JsonSensor input){

        Sensor sensorToUpdate = sensorRepo.getOne(sensorId);
        String oldSensorType = sensorToUpdate.getSensorType().getSensorType();
        sensorToUpdate.setSensorType(sensorTypeRepo.getOne(input.getSensorTypeId()));
        sensorRepo.save(sensorToUpdate);
        String newSensorType = sensorToUpdate.getSensorType().getSensorType();

        List<Operator> operators = operatorRepo.findAll();
        Operator operator = operators.get(0);
        String logMessage = String.format("Sensor with SN: %s was updated by operator: %s. Sensor Type changed from %s to %s.",
                sensorToUpdate.getSn(),
                operator.getName(),
                oldSensorType,
                newSensorType);
        LogItem logItem = new LogItem(sensorToUpdate, operator, logMessage);
        logItemRepo.save(logItem);

        return "Successfully updated sensor : sensor type";
    }

    @RequestMapping(value = "/{sensorId}/updateProject", method = RequestMethod.PATCH)
    public String updateProject(@PathVariable Long sensorId, @RequestBody JsonSensor input){

        Sensor sensorToUpdate = sensorRepo.getOne(sensorId);
        String oldProject = sensorToUpdate.getProject().getName();
        sensorToUpdate.setProject(projectRepo.getOne(input.getProjectId()));
        sensorRepo.save(sensorToUpdate);
        String newProject = sensorToUpdate.getProject().getName();

        List<Operator> operators = operatorRepo.findAll();
        Operator operator = operators.get(0);
        String logMessage = String.format("Sensor with SN: %s was updated by operator: %s. Project changed from %s to %s.",
                sensorToUpdate.getSn(),
                operator.getName(),
                oldProject,
                newProject);
        LogItem logItem = new LogItem(sensorToUpdate, operator, logMessage);
        logItemRepo.save(logItem);

        return "Successfully updated sensor : project";
    }

    @RequestMapping(value = "/{sensorId}/updateMountingLocation", method = RequestMethod.PATCH)
    public String updateMountingLocation(@PathVariable Long sensorId, @RequestBody JsonSensor input){

        Sensor sensorToUpdate = sensorRepo.getOne(sensorId);
        String oldMountingLocation = sensorToUpdate.getMountingLocation().getMountingLocation();
        sensorToUpdate.setMountingLocation(mountingLocationRepo.getOne(input.getMountingLocationId()));
        sensorRepo.save(sensorToUpdate);
        String newMountingLocation = sensorToUpdate.getMountingLocation().getMountingLocation();

        List<Operator> operators = operatorRepo.findAll();
        Operator operator = operators.get(0);
        String logMessage = String.format("Sensor with SN: %s was updated by operator: %s. Mounting Location changed from %s to %s.",
                sensorToUpdate.getSn(),
                operator.getName(),
                oldMountingLocation,
                newMountingLocation);
        LogItem logItem = new LogItem(sensorToUpdate, operator, logMessage);
        logItemRepo.save(logItem);

        return "Successfully updated sensor : mounting location";
    }

    @RequestMapping(value = "/{sensorId}/incrementStatus", method = RequestMethod.PATCH)
    public String incrementStatus(@PathVariable Long sensorId, @RequestBody JsonSensor input){

        Sensor sensorToUpdate = sensorRepo.getOne(sensorId);
        String oldStatus = sensorToUpdate.getStatusCode().getCurrentStatus();
        sensorToUpdate.setStatusCode(statusCodeRepo.getOne(input.getStatusCodeId()));
        sensorRepo.save(sensorToUpdate);
        String newStatus = sensorToUpdate.getStatusCode().getCurrentStatus();

        List<Operator> operators = operatorRepo.findAll();
        Operator operator = operators.get(0);
        String logMessage = String.format("Sensor with SN: %s was updated by operator: %s. Decremented from %s to %s.",
                sensorToUpdate.getSn(),
                operator.getName(),
                oldStatus,
                newStatus);
        LogItem logItem = new LogItem(sensorToUpdate, operator, logMessage);
        logItemRepo.save(logItem);

        return "Successfully updated sensor : incremented status";
    }

    @RequestMapping(value = "/{sensorId}/decrementStatus", method = RequestMethod.PATCH)
    public String decrementStatus(@PathVariable Long sensorId, @RequestBody JsonSensor input){

        Sensor sensorToUpdate = sensorRepo.getOne(sensorId);
        String oldStatus = sensorToUpdate.getStatusCode().getCurrentStatus();
        sensorToUpdate.setStatusCode(statusCodeRepo.getOne(input.getStatusCodeId()));
        sensorRepo.save(sensorToUpdate);
        String newStatus = sensorToUpdate.getStatusCode().getCurrentStatus();

        List<Operator> operators = operatorRepo.findAll();
        Operator operator = operators.get(0);
        String logMessage = String.format("Sensor with SN: %s was updated by operator: %s. Incremented from %s to %s.",
                sensorToUpdate.getSn(),
                operator.getName(),
                oldStatus,
                newStatus);
        LogItem logItem = new LogItem(sensorToUpdate, operator, logMessage);
        logItemRepo.save(logItem);

        return "Successfully updated sensor : decremented status";
    }

}








