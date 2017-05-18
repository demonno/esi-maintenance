package com.example.maintenance.domain.repository;

import com.example.maintenance.domain.model.MaintenancePlan;
import com.example.maintenance.web.dto.CorrectiveRepairsCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MaintenancePlanRepository extends JpaRepository<MaintenancePlan, String>, CustomMaintenancePlanRepository {

    List<CorrectiveRepairsCount> calculateCorrectiveRepairsCountByYear();

}
