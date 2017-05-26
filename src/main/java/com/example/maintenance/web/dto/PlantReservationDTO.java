package com.example.maintenance.web.dto;

import com.example.common.application.dto.BusinessPeriodDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class PlantReservationDTO {
    String plantItemId;
    BusinessPeriodDTO maintenancePeriod;
}
