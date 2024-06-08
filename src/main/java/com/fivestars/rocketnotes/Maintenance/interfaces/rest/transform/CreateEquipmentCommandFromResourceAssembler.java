package com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform;

import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateEquipmentCommand;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.CreateEquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource){
        return new CreateEquipmentCommand(resource.name(),resource.quantity(),resource.budget(),resource.creation(),resource.period());
    }
}
