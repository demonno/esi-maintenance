package com.example.maintenance.service.impl;

import com.example.maintenance.service.ReservationService;
import com.example.maintenance.web.ExternalPlantReservationDTO;
import com.example.maintenance.web.dto.PlantReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    RestTemplate restTemplate;

//    @Value("${rentit.baseurl}")
//    String BASE_RENTIT_URL;
    final String BASE_RENTIT_URL = "http://193.40.11.150";
//    final String BASE_RENTIT_URL = "http://localhost:3000";
    final String RENTIT_LOGIN_USERNAME = "secure";
    final String RENTIT_LOGIN_PASSWORD = "secure";

    @PostConstruct
    private void setUpAuth() {
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor(RENTIT_LOGIN_USERNAME, RENTIT_LOGIN_PASSWORD));
    }

    @Override
    public ExternalPlantReservationDTO createReservation(PlantReservationDTO plantReservationDTO) {
        return restTemplate.postForObject(
                BASE_RENTIT_URL + "/api/inventory/reservations",
                plantReservationDTO,
                ExternalPlantReservationDTO.class);
    }

}
