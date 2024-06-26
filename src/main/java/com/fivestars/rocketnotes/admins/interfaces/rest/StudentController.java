package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Student;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateStudentCommand;
import com.fivestars.rocketnotes.admins.domain.services.StudentCommandService;
import com.fivestars.rocketnotes.admins.domain.services.StudentQueryService;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.CreateStudentResource;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.StudentResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
@Tag(name = "Students", description = "Students API")
@RequiredArgsConstructor
public class StudentController {

    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    @PostMapping
    public Long createStudent(@RequestBody CreateStudentResource createStudentResource) {
        CreateStudentCommand command = new CreateStudentCommand(
                createStudentResource.getFirstName(),
                createStudentResource.getPaternalLastName(),
                createStudentResource.getMaternalLastName(),
                createStudentResource.getDni(),
                createStudentResource.getClassrooms()
        );
        return studentCommandService.handle(command);
    }

    @GetMapping
    public List<StudentResource> getAllStudents() {
        return studentQueryService.getAllStudents().stream()
                .map(student -> StudentResource.builder()
                        .id(student.getId())
                        .firstName(student.getFirstName())
                        .paternalLastName(student.getPaternalLastName())
                        .maternalLastName(student.getMaternalLastName())
                        .dni(student.getDni())
                        .classrooms(student.getClassrooms())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentResource getStudentById(@PathVariable Long id) {
        Student student = studentQueryService.getStudentById(id);
        return StudentResource.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .paternalLastName(student.getPaternalLastName())
                .maternalLastName(student.getMaternalLastName())
                .dni(student.getDni())
                .classrooms(student.getClassrooms())
                .build();
    }
}