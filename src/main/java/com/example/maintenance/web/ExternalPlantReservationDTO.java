package com.example.maintenance.web;

import com.example.common.application.dto.BusinessPeriodDTO;
import com.example.common.rest.ResourceSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class ExternalPlantReservationDTO extends ResourceSupport {
    String _id;
    BusinessPeriodDTO rentalPeriod;
    PlantInventoryItemDTO item;
    String poId;
}
