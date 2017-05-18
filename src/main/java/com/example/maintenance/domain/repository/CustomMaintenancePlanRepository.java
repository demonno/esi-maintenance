package com.example.maintenance.domain.repository;

import com.example.maintenance.web.dto.CorrectiveRepairsCount;
import com.example.maintenance.web.dto.CorrectiveRepairsPrice;

import java.util.List;

public interface CustomMaintenancePlanRepository {

    List<CorrectiveRepairsCount> calculateCorrectiveRepairsCountByYear();
    List<CorrectiveRepairsPrice> calculateCorrectiveRepairsPriceByYear();

}
