package com.example.maintenance.web;


import com.example.common.rest.ResourceSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlantInventoryEntryDTO extends ResourceSupport {
    String _id;
    String name;
    String description;
    BigDecimal price;
}
