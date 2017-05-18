package com.example.maintenance.web.dto;

import com.example.common.application.dto.BusinessPeriodDTO;
import com.example.common.rest.ResourceSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true)
public class PlantMaintenanceDTO extends ResourceSupport {
    String plantHref;
    String plantId;
    BigDecimal price;
    BusinessPeriodDTO maintenancePeriod;
    String description;
}
