package com.example.maintenance.rest.controller;

import com.example.maintenance.service.MaintenanceService;
import com.example.maintenance.web.dto.MaintenancePlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/maintenance/plan")
public class MaintenancePlanController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping
    public List<MaintenancePlanDTO> getAllPlans(){
        return maintenanceService.getAllPlans();
    }

    @GetMapping("/{id}")
    public MaintenancePlanDTO getPlanById(@PathVariable String id){
        return maintenanceService.getPlanById(id);
    }

}
