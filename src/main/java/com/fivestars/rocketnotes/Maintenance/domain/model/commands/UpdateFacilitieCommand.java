package com.fivestars.rocketnotes.Maintenance.domain.model.commands;

import com.fivestars.rocketnotes.Maintenance.domain.model.valueobjects.FacilitieStatus;

public record UpdateFacilitieCommand(Long id, FacilitieStatus status) {
}
