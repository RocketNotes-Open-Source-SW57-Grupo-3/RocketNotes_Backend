package com.fivestars.rocketnotes.students.domain.services;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Attendance;
import com.fivestars.rocketnotes.students.domain.model.queries.GetAllAttendanceForStudentQuery;

import java.util.List;

public interface AttendanceQueryService {

    List<Attendance> handle(GetAllAttendanceForStudentQuery query);
}
