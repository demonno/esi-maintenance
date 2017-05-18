package com.example.maintenance.web.dto;

import lombok.Data;

@Data
public class CorrectiveRepairsCount {
    int year;
    long count;

    public CorrectiveRepairsCount(int year, long count) {
        this.year = year;
        this.count = count;
    }
}
