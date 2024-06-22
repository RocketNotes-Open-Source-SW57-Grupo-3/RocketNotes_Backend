package com.fivestars.rocketnotes.Maintenance.domain.services;

import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateEquipmentCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.DeleteEquipmentByIdCommand;

public interface EquipmentCommandService {
    Long handle(CreateEquipmentCommand command);
    void handle(DeleteEquipmentByIdCommand command);
}
