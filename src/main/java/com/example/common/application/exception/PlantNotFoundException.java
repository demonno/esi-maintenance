package com.example.common.application.exception;

public class PlantNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public PlantNotFoundException(String message) {
        super(message);
    }

}
