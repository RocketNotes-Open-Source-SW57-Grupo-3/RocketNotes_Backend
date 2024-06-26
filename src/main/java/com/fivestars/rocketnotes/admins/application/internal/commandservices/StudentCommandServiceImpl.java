package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Student;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateStudentCommand;
import com.fivestars.rocketnotes.admins.domain.services.StudentCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;

    @Override
    public Long handle(CreateStudentCommand command) {
        Student student = new Student(
                command.firstName(),
                command.paternalLastName(),
                command.maternalLastName(),
                command.dni(),
                command.classrooms()
        );
        studentRepository.save(student);
        return student.getId();
    }
}