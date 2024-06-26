package com.fivestars.rocketnotes.students.interfaces.rest.resources;


import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;

import java.time.LocalDateTime;

public record CreateAttendanceResource(StudentId studentId, CourseId courseId, LocalDateTime date, boolean isPresent) {
}
