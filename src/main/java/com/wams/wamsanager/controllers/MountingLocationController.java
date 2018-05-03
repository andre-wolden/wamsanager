package com.wams.wamsanager.controllers;

import com.wams.wamsanager.JsonModels.JsonMountingLocation;
import com.wams.wamsanager.models.MountingLocation;
import com.wams.wamsanager.repositories.MountingLocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/mounting_location")
public class MountingLocationController {

    @Autowired
    MountingLocationRepo mountingLocationRepo;

    @RequestMapping(value = "/all")
    public List<MountingLocation> all(){
        return mountingLocationRepo.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addMountingLocation(@RequestBody JsonMountingLocation jsonMountingLocation){
        mountingLocationRepo.save(new MountingLocation(jsonMountingLocation.getMountingLocation()));
        
        return "New mounting location saved...";
    }
    
    @RequestMapping(value = "/{mountingLocationId}", method = RequestMethod.GET)
    public Optional<MountingLocation> getMountingLocationById(@PathVariable Long mountingLocationId){
        return mountingLocationRepo.findById(mountingLocationId);
    }

    @RequestMapping(value = "/{mountingLocationId}/update", method = RequestMethod.PATCH)
    public String updateMountingLocation(@PathVariable Long mountingLocationId, @RequestBody JsonMountingLocation jsonMountingLocation){
        MountingLocation mountingLocationToUpdate = mountingLocationRepo.getOne(mountingLocationId);
        mountingLocationToUpdate.setMountingLocation(jsonMountingLocation.getMountingLocation());
        mountingLocationRepo.save(mountingLocationToUpdate);

        return "Mounting location successfully updated";
    }
    
    
}
