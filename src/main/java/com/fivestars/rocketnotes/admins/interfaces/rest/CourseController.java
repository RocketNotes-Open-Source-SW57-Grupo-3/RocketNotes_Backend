package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.fivestars.rocketnotes.admins.domain.model.commands.CreateCourseCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteCourseCommand;
import com.fivestars.rocketnotes.admins.domain.services.ClassroomCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/courses")
@Tag(name = "Courses", description = "Courses API")
@RequiredArgsConstructor
public class CourseController {

    private final ClassroomCommandService classroomCommandService;

    @PostMapping
    public ResponseEntity<Long> createCourse(@RequestBody CreateCourseCommand command) {
        Long courseId = classroomCommandService.handle(command);
        return ResponseEntity.ok(courseId);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId, @RequestParam Long classroomId) {
        classroomCommandService.handle(new DeleteCourseCommand(classroomId, courseId));
        return ResponseEntity.ok().build();
    }
}