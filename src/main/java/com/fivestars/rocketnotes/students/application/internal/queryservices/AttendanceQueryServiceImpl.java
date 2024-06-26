package com.fivestars.rocketnotes.students.application.internal.queryservices;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Attendance;
import com.fivestars.rocketnotes.students.domain.model.queries.GetAllAttendanceForStudentQuery;
import com.fivestars.rocketnotes.students.domain.services.AttendanceQueryService;
import com.fivestars.rocketnotes.students.infraestructure.persistence.jpa.repositories.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceQueryServiceImpl implements AttendanceQueryService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceQueryServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }


    @Override
    public List<Attendance> handle(GetAllAttendanceForStudentQuery query) {
        return attendanceRepository.findAll();
    }
}