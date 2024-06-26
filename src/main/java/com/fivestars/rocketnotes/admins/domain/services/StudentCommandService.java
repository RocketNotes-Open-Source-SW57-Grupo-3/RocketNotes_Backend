package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.commands.CreateStudentCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteStudentCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateStudentCommand;

public interface StudentCommandService {
    Long handle(CreateStudentCommand command);
    void handle(UpdateStudentCommand command);
    void handle(DeleteStudentCommand command);
}