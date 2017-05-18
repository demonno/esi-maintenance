package com.example.maintenance.service.assembler;

import com.example.maintenance.domain.model.MaintenanceTask;
import com.example.maintenance.rest.controller.MaintenanceTaskController;
import com.example.maintenance.web.dto.MaintenanceTaskDTO;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceTaskAssembler extends ResourceAssemblerSupport<MaintenanceTask, MaintenanceTaskDTO> {

    public MaintenanceTaskAssembler() {
        super(MaintenanceTaskController.class, MaintenanceTaskDTO.class);
    }

    @Override
    public MaintenanceTaskDTO toResource(MaintenanceTask maintenanceTask) {
        MaintenanceTaskDTO dto = createResourceWithId(maintenanceTask.getId(), maintenanceTask);
        dto.set_id(maintenanceTask.getId());
        dto.setDescription(maintenanceTask.getDescription());
        dto.setPlantReservationHref(maintenanceTask.getPlantReservationHref());
        dto.setPrice(maintenanceTask.getPrice());
        dto.setSchedule(maintenanceTask.getSchedule());
        dto.setTypeOfWork(maintenanceTask.getTypeOfWork().toString());
        return dto;
    }

}
