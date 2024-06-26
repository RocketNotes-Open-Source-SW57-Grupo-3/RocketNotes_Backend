package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Course;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateCourseCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteCourseCommand;
import com.fivestars.rocketnotes.admins.domain.services.ClassroomCommandService;
import com.fivestars.rocketnotes.admins.domain.services.CourseQueryService;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.CourseResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/courses")
@Tag(name = "Courses", description = "Courses API")
@RequiredArgsConstructor
public class CourseController {

    private final ClassroomCommandService classroomCommandService;
    private final CourseQueryService courseQueryService;

    @GetMapping
    public List<CourseResource> getAllCourses() {
        return courseQueryService.getAllCourses().stream()
                .map(admin -> CourseResource.builder()
                        .id(admin.getId())
                        .roomId(admin.getRoomId())
                        .start(admin.getStart())
                        .end(admin.getEnd())
                        .days(admin.getDays())
                        .teacherId(admin.getTeacher().getId())
                        .image(admin.getImage().getBytes())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CourseResource getCourseById(@PathVariable Long id) {
        Course course = courseQueryService.getCourseById(id);
        return CourseResource.builder()
                .id(course.getId())
                .roomId(course.getRoomId())
                .start(course.getStart())
                .end(course.getEnd())
                .days(course.getDays())
                .teacherId(course.getTeacher().getId())
                .image(course.getImage().getBytes())
                .build();
    }
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