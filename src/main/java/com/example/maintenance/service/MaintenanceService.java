package com.example.maintenance.service;

import com.example.maintenance.web.dto.MaintenancePlanDTO;
import com.example.maintenance.web.dto.MaintenanceTaskDTO;
import com.example.maintenance.web.dto.PlantMaintenanceDTO;

import java.util.List;

public interface MaintenanceService {
    MaintenancePlanDTO correctiveMaintenance(PlantMaintenanceDTO plantMaintenance);
    List<MaintenancePlanDTO> getAllPlans();
    MaintenancePlanDTO getPlanById(String id);
    List<MaintenanceTaskDTO> getAllTasks();
    MaintenanceTaskDTO getTaskById(String id);
}
