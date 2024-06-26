package com.fivestars.rocketnotes.admins.application.internal.queryservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Student;
import com.fivestars.rocketnotes.admins.domain.services.StudentQueryService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}