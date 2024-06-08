package com.fivestars.rocketnotes.Maintenance.domain.services;

import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateEquipmentCommand;

public interface EquipmentCommandService {
    Long handle(CreateEquipmentCommand command);
}
