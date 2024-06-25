package com.fivestars.rocketnotes.admins.domain.services;


import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateTeacherCommand;

public interface TeacherCommandService {
    Long handle(CreateTeacherCommand command);
    void handle(UpdateTeacherCommand command);
    void handle(DeleteTeacherCommand command);
}