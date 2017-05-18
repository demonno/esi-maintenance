package com.example.common.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Embeddable;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Embeddable
@Value
@NoArgsConstructor(force=true,access= AccessLevel.PRIVATE)
@AllArgsConstructor(staticName="of")
public class BusinessPeriod {
    LocalDate startDate;
    LocalDate endDate;

    public int diffInDays() {
        return ((int) DAYS.between(startDate, endDate) + 1);
    }
}
