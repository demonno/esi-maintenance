package com.example.maintenance.domain.model;

import com.example.maintenance.infrastructure.MaintenancePlanIdFactory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MaintenancePlan {

    @Id
    String id;

    int yearOfAction;

    String plantHref;

    @OneToMany(cascade = {CascadeType.ALL})
    List<MaintenanceTask> tasks;

    public static MaintenancePlan of(int yearOfAction, String plantHref, List<MaintenanceTask> tasks) {
        return new MaintenancePlan(MaintenancePlanIdFactory.nextId(), yearOfAction, plantHref, tasks);
    }
}
