package com.fivestars.rocketnotes.students.domain.services;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Attendance;
import com.fivestars.rocketnotes.students.domain.model.commands.CreateAttendanceCommand;
import com.fivestars.rocketnotes.students.domain.model.commands.DeleteAttendanceCommand;
import com.fivestars.rocketnotes.students.domain.model.commands.UpdateAttendanceCommand;

import java.util.Optional;

public interface AttendanceCommandService {

    Optional<Attendance> handle(CreateAttendanceCommand command);
    Optional<Attendance> handle(UpdateAttendanceCommand command);
    void handle(DeleteAttendanceCommand command);

}
