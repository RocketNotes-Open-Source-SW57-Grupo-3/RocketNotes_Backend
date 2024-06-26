package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Teacher;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.services.TeacherCommandService;
import com.fivestars.rocketnotes.admins.domain.services.TeacherQueryService;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.CreateTeacherResource;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.TeacherResource;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.UpdateTeacherResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/teachers")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacherById(@PathVariable Long id){
        var deleteTeacherCommand = new DeleteTeacherCommand(id);
        teacherCommandService.handle(deleteTeacherCommand);
        return ResponseEntity.ok("Teacher deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTeacher(@PathVariable Long id, @RequestBody UpdateTeacherResource resource) {
        UpdateTeacherCommand command = new UpdateTeacherCommand(
                id,
                resource.getFirstName(),
                resource.getPaternalLastName(),
                resource.getMaternalLastName(),
                resource.getDni(),
                resource.getPhone(),
                resource.getEmail()
        );
        teacherCommandService.handle(command);
        return ResponseEntity.ok().build();
    }
}