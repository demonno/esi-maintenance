package com.example.maintenance.web;

import com.example.common.rest.ResourceSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class PlantInventoryItemDTO extends ResourceSupport {
    String _id;
    String serialNumber;
    PlantInventoryEntryDTO plant;
}
