package com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform;

import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateFacilitieCommand;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.CreateFacilitieResource;

public class CreateFacilitieCommandFromResourceAssembler {
    public static CreateFacilitieCommand toCommandFromResource(CreateFacilitieResource resource){
        return new CreateFacilitieCommand(resource.name(), resource.budget(), resource.creation(), resource.period());
    }
}
