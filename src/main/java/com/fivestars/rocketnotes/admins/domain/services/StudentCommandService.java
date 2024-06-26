package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.commands.CreateStudentCommand;

public interface StudentCommandService {
    Long handle(CreateStudentCommand command);
}
