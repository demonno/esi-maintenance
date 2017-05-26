package com.example.maintenance.service;

import com.example.maintenance.web.dto.MaintenancePlanDTO;
import com.example.maintenance.web.dto.MaintenanceTaskDTO;
import com.example.maintenance.web.dto.PlantMaintenanceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface MaintenanceService {
    MaintenancePlanDTO correctiveMaintenance(PlantMaintenanceDTO plantMaintenance) throws JsonProcessingException;
    List<MaintenancePlanDTO> getAllPlans();
    MaintenancePlanDTO getPlanById(String id);
    List<MaintenanceTaskDTO> getAllTasks();
    MaintenanceTaskDTO getTaskById(String id);
}
