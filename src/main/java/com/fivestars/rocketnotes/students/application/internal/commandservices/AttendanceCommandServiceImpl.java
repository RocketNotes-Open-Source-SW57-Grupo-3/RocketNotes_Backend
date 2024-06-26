package com.fivestars.rocketnotes.students.application.internal.commandservices;

import com.fivestars.rocketnotes.students.domain.model.commands.CreateAttendanceCommand;
import com.fivestars.rocketnotes.students.domain.model.aggregates.Attendance;
import com.fivestars.rocketnotes.students.domain.model.commands.DeleteAttendanceCommand;
import com.fivestars.rocketnotes.students.domain.model.commands.UpdateAttendanceCommand;
import com.fivestars.rocketnotes.students.domain.services.AttendanceCommandService;
import com.fivestars.rocketnotes.students.infraestructure.persistence.jpa.repositories.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttendanceCommandServiceImpl implements AttendanceCommandService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceCommandServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Optional<Attendance> handle(CreateAttendanceCommand command) {
        Attendance attendance = new Attendance(command.studentId(), command.courseId(), command.date(), command.isPresent());
        attendanceRepository.save(attendance);
        return Optional.of(attendance);
    }

    @Override
    public Optional<Attendance> handle(UpdateAttendanceCommand command) {
        return Optional.empty();
    }

    @Override
    public void handle(DeleteAttendanceCommand command) {

    }

}