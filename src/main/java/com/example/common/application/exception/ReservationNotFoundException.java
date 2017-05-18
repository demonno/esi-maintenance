package com.example.common.application.exception;

public class ReservationNotFoundException extends Exception {
    public ReservationNotFoundException(String id) {
        super("Reservation with id: " + id + " wasn't found :(");
    }
}
