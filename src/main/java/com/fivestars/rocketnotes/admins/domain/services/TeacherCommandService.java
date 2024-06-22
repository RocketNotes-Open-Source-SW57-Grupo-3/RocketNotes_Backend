package com.fivestars.rocketnotes.admins.domain.services;


import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteTeacherCommand;

public interface TeacherCommandService {
    Long handle(CreateTeacherCommand command);
    void handle(DeleteTeacherCommand command);
}