package com.example.maintenance.domain.repository.impl;

import com.example.maintenance.domain.model.TypeOfWork;
import com.example.maintenance.domain.repository.CustomMaintenancePlanRepository;
import com.example.maintenance.web.dto.CorrectiveRepairsCount;
import com.example.maintenance.web.dto.CorrectiveRepairsPrice;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.List;

public class MaintenancePlanRepositoryImpl implements CustomMaintenancePlanRepository {

    @Autowired
    EntityManager em;

    @Override
    public List<CorrectiveRepairsCount> calculateCorrectiveRepairsCountByYear() {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int lastFiveYear = currentYear - 5;


        return em.createQuery("select new com.example.maintenance.web.dto.CorrectiveRepairsCount(plan.yearOfAction as year, count(plan.id) as count) " +
                " from MaintenancePlan as plan " +
                " left join plan.tasks as t " +
                " where plan.yearOfAction between :lastFiveYear and :currentYear " +
                " and t.typeOfWork = :type "+
                " group by plan.yearOfAction ", CorrectiveRepairsCount.class)
                .setParameter("lastFiveYear", lastFiveYear)
                .setParameter("currentYear", currentYear)
                .setParameter("type", TypeOfWork.CORRECTIVE)
                .getResultList();
    }

    @Override
    public List<CorrectiveRepairsPrice> calculateCorrectiveRepairsPriceByYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int lastFiveYear = currentYear - 5;

        return em.createQuery("select new com.example.maintenance.web.dto.CorrectiveRepairsPrice(plan.yearOfAction as year, sum(t.price) as count) " +
                " from MaintenancePlan as plan " +
                " left join plan.tasks as t " +
                " where plan.yearOfAction between :lastFiveYear and :currentYear " +
                " and t.typeOfWork = :type "+
                " group by plan.yearOfAction ", CorrectiveRepairsPrice.class)
                .setParameter("lastFiveYear", lastFiveYear)
                .setParameter("currentYear", currentYear)
                .setParameter("type", TypeOfWork.CORRECTIVE)
                .getResultList();
    }

}
