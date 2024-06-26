package com.fivestars.rocketnotes.Maintenance.domain.model.commands;

import com.fivestars.rocketnotes.Maintenance.domain.model.valueobjects.EquipmentStatus;

public record UpdateEquipmentCommand(Long id, EquipmentStatus status) {
}
