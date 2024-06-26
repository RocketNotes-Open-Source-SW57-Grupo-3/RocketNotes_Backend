package com.fivestars.rocketnotes.Maintenance.domain.services;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Facilitie;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateFacilitieCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.DeleteFacilitieByIdCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.UpdateFacilitieCommand;

import java.util.Optional;

public interface FacilitieCommandService {
    Long handle(CreateFacilitieCommand command);
    void handle(DeleteFacilitieByIdCommand command);
    Optional<Facilitie> handle(UpdateFacilitieCommand command);
}
