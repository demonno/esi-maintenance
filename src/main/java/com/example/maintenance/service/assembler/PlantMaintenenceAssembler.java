package com.example.maintenance.service.assembler;

import com.example.maintenance.domain.model.MaintenancePlan;
import com.example.maintenance.rest.controller.MaintenanceController;
import com.example.maintenance.web.dto.PlantMaintenanceDTO;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

@Service
public class PlantMaintenenceAssembler
        extends ResourceAssemblerSupport<MaintenancePlan, PlantMaintenanceDTO> {

    public PlantMaintenenceAssembler() {
        super(MaintenanceController.class, PlantMaintenanceDTO.class);
    }

    @Override
    public PlantMaintenanceDTO toResource(MaintenancePlan plan) {
        PlantMaintenanceDTO dto = createResourceWithId(plan.getId(), plan);
        dto.setPlantHref(plan.getPlantHref());
        return dto;
    }
}