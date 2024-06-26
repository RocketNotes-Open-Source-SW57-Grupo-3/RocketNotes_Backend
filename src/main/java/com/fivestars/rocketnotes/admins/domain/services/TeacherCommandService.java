package com.fivestars.rocketnotes.admins.domain.services;


import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;

public interface TeacherCommandService {
    Long handle(CreateTeacherCommand command);
}