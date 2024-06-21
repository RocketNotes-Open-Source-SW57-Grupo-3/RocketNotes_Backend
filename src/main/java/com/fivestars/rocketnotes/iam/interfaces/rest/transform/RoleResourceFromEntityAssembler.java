package com.fivestars.rocketnotes.iam.interfaces.rest.transform;


import com.fivestars.rocketnotes.iam.domain.model.entities.Role;
import com.fivestars.rocketnotes.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role entity) {
        return new RoleResource(entity.getId(), entity.getStringName());
    }
}
