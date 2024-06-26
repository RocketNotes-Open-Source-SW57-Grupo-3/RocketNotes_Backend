package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Teacher;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.services.TeacherCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherCommandServiceImpl implements TeacherCommandService {

    private final TeacherRepository teacherRepository;

    @Override
    public Long handle(CreateTeacherCommand command) {
        Teacher teacher = new Teacher(
                command.firstName(),
                command.paternalLastName(),
                command.maternalLastName(),
                command.dni(),
                command.phone(),
                command.email()
        );
        teacherRepository.save(teacher);
        return teacher.getId();
    }
}