package com.example.maintenance.web.dto;

import com.example.common.rest.ResourceSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(force = true)
public class MaintenancePlanDTO extends ResourceSupport {
    String _id;
    List<MaintenanceTaskDTO> maintenanceTasks;
    int yearOfAction;
    String plantHref;
}
