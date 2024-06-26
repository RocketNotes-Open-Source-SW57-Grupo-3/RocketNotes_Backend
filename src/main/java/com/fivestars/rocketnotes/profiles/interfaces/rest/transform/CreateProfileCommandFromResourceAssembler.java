package com.fivestars.rocketnotes.profiles.interfaces.rest.transform;

import com.fivestars.rocketnotes.profiles.domain.model.commands.CreateProfileCommand;
import com.fivestars.rocketnotes.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email());
    }
}
