package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.commands.CreateAdminCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteAdminCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteCourseCommand;

public interface AdminCommandService {
    Long handle(CreateAdminCommand command);
    void handle(DeleteAdminCommand command);
}

