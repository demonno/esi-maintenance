package com.example.maintenance.service.impl;

import com.example.common.application.dto.BusinessPeriodDTO;
import com.example.common.service.assembler.BusinessPeriodAssembler;
import com.example.maintenance.domain.model.MaintenancePlan;
import com.example.maintenance.domain.model.MaintenanceTask;
import com.example.maintenance.domain.model.TypeOfWork;
import com.example.maintenance.domain.repository.MaintenancePlanRepository;
import com.example.maintenance.domain.repository.MaintenanceTaskRepository;
import com.example.maintenance.service.MaintenanceService;
import com.example.maintenance.service.ReservationService;
import com.example.maintenance.service.assembler.MaintenancePlanAssembler;
import com.example.maintenance.service.assembler.MaintenanceTaskAssembler;
import com.example.maintenance.web.ExternalPlantReservationDTO;
import com.example.maintenance.web.dto.PlantReservationDTO;
import com.example.maintenance.web.dto.MaintenancePlanDTO;
import com.example.maintenance.web.dto.MaintenanceTaskDTO;
import com.example.maintenance.web.dto.PlantMaintenanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    ReservationService reservationService;

    @Autowired
    MaintenancePlanRepository maintenancePlanRepository;

    @Autowired
    MaintenanceTaskRepository maintenanceTaskRepository;

    @Autowired
    BusinessPeriodAssembler businessPeriodAssembler;

    @Autowired
    MaintenancePlanAssembler maintenancePlanAssembler;

    @Autowired
    MaintenanceTaskAssembler maintenanceTaskAssembler;

    @Transactional
    @Override
    public MaintenancePlanDTO correctiveMaintenance(PlantMaintenanceDTO plantMaintenance) {

        //  Api Call To Rentit PS13
        String reservationHref = "http://example.com";


        ExternalPlantReservationDTO plantReservationDTO = reservationService.createReservation(
                PlantReservationDTO.of(plantMaintenance.getPlantId(), plantMaintenance.getMaintenancePeriod()));

        MaintenanceTask maintenanceTask = MaintenanceTask.createMaintenanceTask(
                TypeOfWork.CORRECTIVE, plantMaintenance.getPrice(), plantMaintenance.getDescription(),
                businessPeriodAssembler.toBusinessPeriod(plantMaintenance.getMaintenancePeriod()),
                reservationHref);
        maintenanceTaskRepository.save(maintenanceTask);

        List<MaintenanceTask> taskList = new ArrayList<>();
        taskList.add(maintenanceTask);

        MaintenancePlan maintenancePlan = MaintenancePlan.of(2018,
                plantMaintenance.getPlantHref(), taskList);
        maintenancePlanRepository.save(maintenancePlan);

        return maintenancePlanAssembler.toResource(maintenancePlan);

    }

    @Override
    public List<MaintenancePlanDTO> getAllPlans() {
        return maintenancePlanAssembler.toResources(maintenancePlanRepository.findAll());
    }

    @Override
    public MaintenancePlanDTO getPlanById(String id) {
        return maintenancePlanAssembler.toResource(maintenancePlanRepository.findOne(id));
    }

    @Override
    public List<MaintenanceTaskDTO> getAllTasks() {
        return maintenanceTaskAssembler.toResources(maintenanceTaskRepository.findAll());
    }

    @Override
    public MaintenanceTaskDTO getTaskById(String id) {
        return maintenanceTaskAssembler.toResource(maintenanceTaskRepository.findOne(id));
    }
}
