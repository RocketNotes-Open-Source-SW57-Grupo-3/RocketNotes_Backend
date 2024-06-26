package com.fivestars.rocketnotes.students.domain.services;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Grade;
import com.fivestars.rocketnotes.students.domain.model.commands.CreateGradeCommand;

import java.util.Optional;

public interface GradeCommandService {

    Optional<Grade> handle(CreateGradeCommand command);

}
