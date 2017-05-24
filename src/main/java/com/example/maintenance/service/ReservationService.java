package com.example.maintenance.service;

import com.example.maintenance.web.ExternalPlantReservationDTO;
import com.example.maintenance.web.dto.PlantReservationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ReservationService {
    ExternalPlantReservationDTO createReservation(PlantReservationDTO plantReservationDTO) throws JsonProcessingException;
}
