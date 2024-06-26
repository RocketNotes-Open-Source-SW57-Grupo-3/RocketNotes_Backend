package com.fivestars.rocketnotes.students.domain.model.commands;

import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;

public record CreateGradeCommand(StudentId studentId, CourseId courseId, int grade) {
}
