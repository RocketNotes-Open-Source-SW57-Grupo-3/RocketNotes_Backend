package com.fivestars.rocketnotes.Maintenance.domain.services;

import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateFacilitieCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.DeleteFacilitieByIdCommand;

public interface FacilitieCommandService {
    Long handle(CreateFacilitieCommand command);
    void handle(DeleteFacilitieByIdCommand command);
}
