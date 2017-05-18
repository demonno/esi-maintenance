package com.example.maintenance.web.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CorrectiveRepairsPrice {
    int year;
    BigDecimal price;

    public CorrectiveRepairsPrice(int year, BigDecimal price) {
        this.year = year;
        this.price = price;
    }
}
