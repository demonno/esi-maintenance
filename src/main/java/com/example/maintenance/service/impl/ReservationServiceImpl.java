package com.example.maintenance.service.impl;

import com.example.maintenance.service.ReservationService;
import com.example.maintenance.web.ExternalPlantReservationDTO;
import com.example.maintenance.web.dto.PlantReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    RestTemplate restTemplate;

//    @Value("${rentit.baseurl}")
    final String BASE_RENTIT_URL = "http://193.40.11.150:8080";
//    final String BASE_RENTIT_URL = "http://localhost:3000";

    @Override
    public ExternalPlantReservationDTO createReservation(PlantReservationDTO plantReservationDTO) {

        return restTemplate.postForObject(
                BASE_RENTIT_URL + "/api/inventory/reservations",
                plantReservationDTO,
                ExternalPlantReservationDTO.class);
    }
}
