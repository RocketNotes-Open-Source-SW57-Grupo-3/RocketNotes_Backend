package com.fivestars.rocketnotes.iam.domain.services;


import com.fivestars.rocketnotes.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
