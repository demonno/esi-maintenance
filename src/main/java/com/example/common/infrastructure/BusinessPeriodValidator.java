package com.example.common.infrastructure;

import com.example.common.domain.model.BusinessPeriod;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class BusinessPeriodValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return BusinessPeriod.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BusinessPeriod bp = (BusinessPeriod) o;

        if( bp == null)
            errors.rejectValue("bp", "BusinessPeriod cannot be null");

        if (bp.getStartDate() == null)
            errors.rejectValue("bp.start.date", "BusinessPeriod start date cannot be null");

        if (bp.getEndDate() == null)
            errors.rejectValue("bp.end.date", "BusinessPeriod end date cannot be null");

        // do not accept orders with return date equal to start date
        if (!bp.getStartDate().isBefore(bp.getEndDate())){
            errors.rejectValue("startDate", "dates.invalid");
        }

    }
}
