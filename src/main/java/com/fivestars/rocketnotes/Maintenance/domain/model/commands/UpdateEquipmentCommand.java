package com.fivestars.rocketnotes.Maintenance.domain.model.commands;

import com.fivestars.rocketnotes.Maintenance.domain.model.valueobjects.EquipmentStatus;

public record UpdateEquipmentCommand(Long id, String name, Integer quantity, Integer budget, String creation, String period, EquipmentStatus status) {
}
