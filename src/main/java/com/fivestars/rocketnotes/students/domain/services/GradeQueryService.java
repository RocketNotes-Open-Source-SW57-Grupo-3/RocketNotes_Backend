package com.fivestars.rocketnotes.students.domain.services;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Grade;
import com.fivestars.rocketnotes.students.domain.model.queries.GetAllGradesForStudentQuery;

import java.util.List;

public interface GradeQueryService {
    List<Grade> handle(GetAllGradesForStudentQuery query);
}
