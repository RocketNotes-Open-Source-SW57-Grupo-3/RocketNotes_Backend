package com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Equipment;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment equipment){
        return new EquipmentResource(
                equipment.getId(),
                equipment.getName(),
                equipment.getQuantity(),
                equipment.getBudget(),
                equipment.getCreation(),
                equipment.getPeriod(),
                equipment.getStatus()
        );
    }
}
