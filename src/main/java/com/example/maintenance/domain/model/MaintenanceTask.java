package com.example.maintenance.domain.model;

import com.example.common.domain.model.BusinessPeriod;
import com.example.maintenance.infrastructure.MaintenancePlanIdFactory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(force=true,access= AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
public class MaintenanceTask {

    @Id
    String id;

    String description;

    @Enumerated(EnumType.STRING)
    TypeOfWork typeOfWork;

    BigDecimal price;

    BusinessPeriod schedule;

    String plantReservationHref;

    public static MaintenanceTask createMaintenanceTask(TypeOfWork typeOfWork, BigDecimal price, String description, BusinessPeriod businessPeriod, String reservationHref) {
        return MaintenanceTask.of(MaintenancePlanIdFactory.nextId(), description, typeOfWork, price, businessPeriod, reservationHref);
    }
}
