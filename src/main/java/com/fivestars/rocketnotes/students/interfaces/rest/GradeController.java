package com.fivestars.rocketnotes.students.interfaces.rest;

import com.fivestars.rocketnotes.students.application.internal.commandservices.GradeCommandServiceImpl;
import com.fivestars.rocketnotes.students.application.internal.queryservices.GradeQueryServiceImpl;
import com.fivestars.rocketnotes.students.domain.model.aggregates.Grade;
import com.fivestars.rocketnotes.students.domain.model.commands.CreateGradeCommand;
import com.fivestars.rocketnotes.students.domain.model.queries.GetAllGradesForStudentQuery;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/Grade", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name ="Grades", description = "Grades Management Endpoint")
public class GradeController {

    private final GradeCommandServiceImpl commandService;
    private final GradeQueryServiceImpl queryService;

    public GradeController(GradeCommandServiceImpl commandService, GradeQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody CreateGradeCommand command) {
        return ResponseEntity.ok(commandService.handle(command).orElseThrow());
    }



    @GetMapping("/{courseId}/{studentId}")
    public ResponseEntity<List<Grade>> getAllGradesForStudent(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        return ResponseEntity.ok(queryService.handle(new GetAllGradesForStudentQuery(new StudentId(studentId), new CourseId(courseId))));
    }
}