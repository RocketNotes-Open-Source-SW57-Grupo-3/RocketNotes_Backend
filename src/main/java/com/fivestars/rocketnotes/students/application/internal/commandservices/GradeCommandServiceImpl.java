package com.fivestars.rocketnotes.students.application.internal.commandservices;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Grade;
import com.fivestars.rocketnotes.students.domain.model.commands.CreateGradeCommand;
import com.fivestars.rocketnotes.students.domain.services.GradeCommandService;
import com.fivestars.rocketnotes.students.infraestructure.persistence.jpa.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeCommandServiceImpl implements GradeCommandService {

    private final GradeRepository gradeRepository;

    public GradeCommandServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Optional<Grade> handle(CreateGradeCommand command) {
        Grade grade = new Grade(command.studentId(), command.courseId(), command.grade());
        gradeRepository.save(grade);
        return Optional.of(grade);
    }
}