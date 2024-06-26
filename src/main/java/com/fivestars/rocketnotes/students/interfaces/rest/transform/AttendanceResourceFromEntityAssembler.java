package com.fivestars.rocketnotes.students.interfaces.rest.transform;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Attendance;
import com.fivestars.rocketnotes.students.interfaces.rest.resources.AttendanceResource;

public class AttendanceResourceFromEntityAssembler {
    public static AttendanceResource toResourceFromEntity(Attendance attendance){
        return new AttendanceResource (
            attendance.getStudentId(),
            attendance.getCourseId(),
            attendance.isPresent()
        );
    }
}
