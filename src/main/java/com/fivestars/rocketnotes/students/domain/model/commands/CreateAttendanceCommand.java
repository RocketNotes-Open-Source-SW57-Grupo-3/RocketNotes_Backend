package com.fivestars.rocketnotes.students.domain.model.commands;

import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;

import java.time.LocalDateTime;

public record CreateAttendanceCommand(StudentId studentId, CourseId courseId, LocalDateTime date, boolean isPresent) {

}