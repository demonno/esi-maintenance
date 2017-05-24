package com.example.maintenance.rest.controller;

import com.example.maintenance.service.MaintenanceService;
import com.example.maintenance.web.dto.MaintenancePlanDTO;
import com.example.maintenance.web.dto.PlantMaintenanceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping
    public String getTest(){
        return "OK";
    }

    @GetMapping("/{id}")
    public String getMaintenancePlan(){
        return "OK";
    }


    @PostMapping
    public ResponseEntity<MaintenancePlanDTO>
    correctiveMaintenance(@RequestBody PlantMaintenanceDTO plantMaintenance) throws JsonProcessingException {
        MaintenancePlanDTO maintenancePlanDTO = maintenanceService.correctiveMaintenance(plantMaintenance);
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(maintenancePlanDTO, headers, HttpStatus.CREATED);
    }

}
