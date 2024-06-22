package com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Equipment;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.UpdateEquipmentCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.valueobjects.EquipmentStatus;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.UpdateEquipmentResource;

public class UpdateEquipmentCommandFromResourceAssembler {
    public static UpdateEquipmentCommand toCommandFromResource(Long id, UpdateEquipmentResource resource) {
        return new UpdateEquipmentCommand(id, resource.status());
    }
}
