package com.example.common.service.assembler;

import com.example.common.application.dto.BusinessPeriodDTO;
import com.example.common.domain.model.BusinessPeriod;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessPeriodAssembler {

    public BusinessPeriodDTO toResource(BusinessPeriod bp) {
        BusinessPeriodDTO dto = new BusinessPeriodDTO();
        dto.setStartDate(bp.getStartDate());
        dto.setEndDate(bp.getEndDate());
        return dto;
    }

    public List<BusinessPeriodDTO> toResources(List<BusinessPeriod> bps) {
        return bps.stream().map(this::toResource).collect(Collectors.toList());
    }

    public BusinessPeriod toBusinessPeriod(BusinessPeriodDTO dto){
        return BusinessPeriod.of(dto.getStartDate(), dto.getEndDate());
    }

}
