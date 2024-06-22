package com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources;

import com.fivestars.rocketnotes.Maintenance.domain.model.valueobjects.EquipmentStatus;

public record UpdateEquipmentResource(Long id, String name, Integer quantity, Integer budget, String creation, String period , EquipmentStatus status) {
}
