package com.fivestars.rocketnotes.Maintenance.domain.services;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Equipment;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateEquipmentCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.DeleteEquipmentByIdCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.UpdateEquipmentCommand;

import java.util.Optional;

public interface EquipmentCommandService {
    Long handle(CreateEquipmentCommand command);
    void handle(DeleteEquipmentByIdCommand command);
    Optional<Equipment> handle(UpdateEquipmentCommand command);
}
