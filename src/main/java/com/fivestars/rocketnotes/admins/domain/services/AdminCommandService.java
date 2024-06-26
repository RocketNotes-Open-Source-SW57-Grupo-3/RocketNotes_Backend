package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.commands.CreateAdminCommand;

public interface AdminCommandService {
    Long handle(CreateAdminCommand command);
}

