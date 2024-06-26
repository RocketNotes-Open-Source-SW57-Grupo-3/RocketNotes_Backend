package com.fivestars.rocketnotes.students.domain.model.queries;

import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;

public record GetAllGradesForStudentQuery(StudentId studentId, CourseId courseId) {
}
