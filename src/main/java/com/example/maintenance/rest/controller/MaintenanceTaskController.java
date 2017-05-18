package com.example.maintenance.rest.controller;

import com.example.maintenance.service.MaintenanceService;
import com.example.maintenance.web.dto.MaintenanceTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/maintenance/task")
public class MaintenanceTaskController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping
    public List<MaintenanceTaskDTO> getAllTasks(){
        return maintenanceService.getAllTasks();
    }

    @GetMapping("/{id}")
    public MaintenanceTaskDTO getTask(@PathVariable String id){
        return maintenanceService.getTaskById(id);
    }

}
