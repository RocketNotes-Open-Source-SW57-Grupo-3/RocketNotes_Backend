package com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform;

import com.fivestars.rocketnotes.Maintenance.domain.model.commands.UpdateFacilitieCommand;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.UpdateFacilitieResource;

public class UpdateFacilitieCommandFromResourceAssembler {
    public static UpdateFacilitieCommand toCommandFromResource(Long id, UpdateFacilitieResource resource) {
        return new UpdateFacilitieCommand(id, resource.status());
    }
}
