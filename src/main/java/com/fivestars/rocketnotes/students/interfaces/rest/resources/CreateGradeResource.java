package com.fivestars.rocketnotes.students.interfaces.rest.resources;

import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;

public record CreateGradeResource(StudentId studentId, CourseId courseId, int grade) {
}
