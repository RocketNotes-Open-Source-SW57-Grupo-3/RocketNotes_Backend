package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.commands.CreateAdminCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteAdminCommand;

public interface AdminCommandService {
    Long handle(CreateAdminCommand command);
    void handle(DeleteAdminCommand command);
}

