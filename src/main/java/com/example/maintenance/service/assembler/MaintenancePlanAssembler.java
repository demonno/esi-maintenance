package com.example.maintenance.service.assembler;

import com.example.maintenance.domain.model.MaintenancePlan;
import com.example.maintenance.rest.controller.MaintenancePlanController;
import com.example.maintenance.web.dto.MaintenancePlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

@Service
public class MaintenancePlanAssembler extends ResourceAssemblerSupport<MaintenancePlan, MaintenancePlanDTO> {

    @Autowired
    MaintenanceTaskAssembler maintenanceTaskAssembler;

    public MaintenancePlanAssembler() {
        super(MaintenancePlanController.class, MaintenancePlanDTO.class);
    }

    @Override
    public MaintenancePlanDTO toResource(MaintenancePlan plan) {
        MaintenancePlanDTO dto = createResourceWithId(plan.getId(), plan);
        dto.set_id(plan.getId());
        dto.setPlantHref(plan.getPlantHref());
        dto.setYearOfAction(plan.getYearOfAction());
        dto.setMaintenanceTasks(maintenanceTaskAssembler.toResources(plan.getTasks()));
        return dto;
    }
}
