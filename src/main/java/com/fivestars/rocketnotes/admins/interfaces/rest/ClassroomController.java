package com.fivestars.rocketnotes.admins.interfaces.rest;


import com.fivestars.rocketnotes.admins.domain.model.commands.*;
import com.fivestars.rocketnotes.admins.domain.services.ClassroomCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/classrooms")
@Tag(name = "Classrooms", description = "Classrooms API")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomCommandService classroomCommandService;

    @PostMapping
    public ResponseEntity<Long> createClassroom(@RequestBody CreateClassroomCommand command) {
        Long classroomId = classroomCommandService.handle(command);
        return ResponseEntity.ok(classroomId);
    }

    @PostMapping("/{classroomId}/students")
    public ResponseEntity<Void> addStudentToClassroom(@PathVariable Long classroomId, @RequestBody Long studentId) {
        classroomCommandService.handle(new AddStudentToClassroomCommand(classroomId, studentId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{classroomId}/students/{studentId}")
    public ResponseEntity<Void> removeStudentFromClassroom(@PathVariable Long classroomId, @PathVariable Long studentId) {
        classroomCommandService.handle(new RemoveStudentFromClassroomCommand(classroomId, studentId));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{classroomId}/courses")
    public ResponseEntity<Long> createCourse(@PathVariable Long classroomId, @RequestBody CreateCourseCommand command) {
        Long courseId = classroomCommandService.handle(command);
        return ResponseEntity.ok(courseId);
    }

    @DeleteMapping("/{classroomId}/courses/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long classroomId, @PathVariable Long courseId) {
        classroomCommandService.handle(new DeleteCourseCommand(classroomId, courseId));
        return ResponseEntity.ok().build();
    }
}