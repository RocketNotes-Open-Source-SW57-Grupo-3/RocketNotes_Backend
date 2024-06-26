package com.fivestars.rocketnotes.students.interfaces.rest;

import com.fivestars.rocketnotes.students.application.internal.commandservices.AttendanceCommandServiceImpl;
import com.fivestars.rocketnotes.students.application.internal.queryservices.AttendanceQueryServiceImpl;
import com.fivestars.rocketnotes.students.domain.model.aggregates.Attendance;
import com.fivestars.rocketnotes.students.domain.model.commands.CreateAttendanceCommand;
import com.fivestars.rocketnotes.students.domain.model.commands.DeleteAttendanceCommand;
import com.fivestars.rocketnotes.students.domain.model.commands.UpdateAttendanceCommand;
import com.fivestars.rocketnotes.students.domain.model.queries.GetAllAttendanceForStudentQuery;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/Attendance", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name ="Attendances", description = "Attendances Management Endpoint")
public class AttendanceController {

    private final AttendanceCommandServiceImpl commandService;
    private final AttendanceQueryServiceImpl queryService;

    public AttendanceController(AttendanceCommandServiceImpl commandService, AttendanceQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody CreateAttendanceCommand command) {
        return ResponseEntity.ok(commandService.handle(command).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody UpdateAttendanceCommand command) {
        return ResponseEntity.ok(commandService.handle(command).orElseThrow());
    }

    @DeleteMapping("/{courseId}/{studentId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable StudentId studentId, CourseId courseId) {
        commandService.handle(new DeleteAttendanceCommand(studentId,courseId));
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{courseId}/{studentId}")
    public ResponseEntity<List<Attendance>> getAllAttendanceForStudent(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        return ResponseEntity.ok(queryService.handle(new GetAllAttendanceForStudentQuery(new StudentId(studentId), new CourseId(courseId))));
    }
}
