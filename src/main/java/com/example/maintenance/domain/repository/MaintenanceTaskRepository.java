package com.example.maintenance.domain.repository;

import com.example.maintenance.domain.model.MaintenanceTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, String> {

}
