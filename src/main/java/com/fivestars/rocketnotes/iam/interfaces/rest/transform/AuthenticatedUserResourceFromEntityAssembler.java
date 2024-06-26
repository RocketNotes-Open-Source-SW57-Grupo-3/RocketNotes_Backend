package com.fivestars.rocketnotes.iam.interfaces.rest.transform;


import com.fivestars.rocketnotes.iam.domain.model.aggregates.User;
import com.fivestars.rocketnotes.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User entity, String token) {
        return new AuthenticatedUserResource(entity.getId(), entity.getUsername(), token);
    }
}
