package com.example.maintenance.domain.repository;

import com.example.MaintenanceApplication;
import com.example.maintenance.web.dto.CorrectiveRepairsCount;
import com.example.maintenance.web.dto.CorrectiveRepairsPrice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MaintenanceApplication.class)
@Sql(scripts= "classpath:inserts.sql")
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MaintenancePlanRepositoryTest {

    @Autowired
    MaintenancePlanRepository maintenancePlanRepository;


    @Test
    public void queryMaintenance() {
        assertThat(maintenancePlanRepository.count()).isEqualTo(5L);
    }

    @Test
    public void testCalculateCorrectiveRepairs() {
        List<CorrectiveRepairsCount> rp = maintenancePlanRepository.calculateCorrectiveRepairsCountByYear();
        CorrectiveRepairsCount rp1 = rp.get(0);
        CorrectiveRepairsCount rp2 = rp.get(1);

        assertThat(rp.size()).isEqualTo(2);

        assertThat(rp1.getCount()).isEqualTo(2);
        assertThat(rp1.getYear()).isEqualTo(2017);

        assertThat(rp2.getCount()).isEqualTo(3);
        assertThat(rp2.getYear()).isEqualTo(2016);
    }

    @Test
    public void testCalculateCorrectiveRepairsPrice() {
        List<CorrectiveRepairsPrice> rp = maintenancePlanRepository.calculateCorrectiveRepairsPriceByYear();
        CorrectiveRepairsPrice rp1 = rp.get(0);
        CorrectiveRepairsPrice rp2 = rp.get(1);

        assertThat(rp.size()).isEqualTo(2);

        assertThat(rp1.getYear()).isEqualTo(2017);
        assertThat(rp1.getPrice()).isEqualByComparingTo(new BigDecimal(820.00));

        assertThat(rp2.getYear()).isEqualTo(2016);
        assertThat(rp2.getPrice()).isEqualByComparingTo(new BigDecimal(900.00));

    }

}
