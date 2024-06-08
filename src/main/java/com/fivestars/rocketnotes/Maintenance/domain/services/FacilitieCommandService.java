package com.fivestars.rocketnotes.Maintenance.domain.services;

import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateFacilitieCommand;

public interface FacilitieCommandService {
    Long handle(CreateFacilitieCommand command);
}
