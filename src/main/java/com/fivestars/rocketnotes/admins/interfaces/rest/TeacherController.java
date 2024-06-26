package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Teacher;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.services.TeacherCommandService;
import com.fivestars.rocketnotes.admins.domain.services.TeacherQueryService;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.CreateTeacherResource;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.TeacherResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/teachers")
@Tag(name = "Teachers", description = "Teachers API")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherCommandService teacherCommandService;
    private final TeacherQueryService teacherQueryService;

    @PostMapping
    public Long createTeacher(@RequestBody CreateTeacherResource createTeacherResource) {
        CreateTeacherCommand command = new CreateTeacherCommand(
                createTeacherResource.getFirstName(),
                createTeacherResource.getPaternalLastName(),
                createTeacherResource.getMaternalLastName(),
                createTeacherResource.getDni(),
                createTeacherResource.getPhone(),
                createTeacherResource.getEmail()
        );
        return teacherCommandService.handle(command);
    }

    @GetMapping
    public List<TeacherResource> getAllTeachers() {
        return teacherQueryService.getAllTeachers().stream()
                .map(teacher -> TeacherResource.builder()
                        .id(teacher.getId())
                        .firstName(teacher.getFirstName())
                        .paternalLastName(teacher.getPaternalLastName())
                        .maternalLastName(teacher.getMaternalLastName())
                        .dni(teacher.getDni())
                        .phone(teacher.getPhone())
                        .email(teacher.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TeacherResource getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherQueryService.getTeacherById(id);
        return TeacherResource.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .paternalLastName(teacher.getPaternalLastName())
                .maternalLastName(teacher.getMaternalLastName())
                .dni(teacher.getDni())
                .phone(teacher.getPhone())
                .email(teacher.getEmail())
                .build();
    }
}