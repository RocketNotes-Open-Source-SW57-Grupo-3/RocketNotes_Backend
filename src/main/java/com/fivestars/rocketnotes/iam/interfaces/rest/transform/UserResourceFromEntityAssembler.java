package com.fivestars.rocketnotes.iam.interfaces.rest.transform;

import com.fivestars.rocketnotes.iam.domain.model.entities.Role;
import com.fivestars.rocketnotes.iam.domain.model.aggregates.User;
import com.fivestars.rocketnotes.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        var roles = entity.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(entity.getId(), entity.getUsername(), roles);
    }
}
