package com.fivestars.rocketnotes.profiles.interfaces.rest.transform;

import com.fivestars.rocketnotes.profiles.domain.model.aggregates.Profile;
import com.fivestars.rocketnotes.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress());
    }
}