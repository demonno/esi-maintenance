package com.example.common.application.exception;

public class PurchaseOrderNotFoundException extends Exception {
    public PurchaseOrderNotFoundException(String id) {
        super("Purchase order with id: " + id + " wasn't found. :(");
    }
}
