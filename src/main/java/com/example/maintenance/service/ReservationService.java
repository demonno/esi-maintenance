package com.example.maintenance.service;

import com.example.maintenance.web.ExternalPlantReservationDTO;
import com.example.maintenance.web.dto.PlantReservationDTO;

public interface ReservationService {
    ExternalPlantReservationDTO createReservation(PlantReservationDTO plantReservationDTO);
}
