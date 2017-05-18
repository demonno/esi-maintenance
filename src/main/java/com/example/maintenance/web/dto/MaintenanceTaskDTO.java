package com.example.maintenance.web.dto;

import com.example.common.domain.model.BusinessPeriod;
import com.example.common.rest.ResourceSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true)
public class MaintenanceTaskDTO extends ResourceSupport{
    String _id;
    String description;
    String typeOfWork;
    BigDecimal price;
    BusinessPeriod schedule;
    String plantReservationHref;
}
