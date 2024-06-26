package com.fivestars.rocketnotes.students.interfaces.rest.transform;

import com.fivestars.rocketnotes.students.domain.model.commands.CreateAttendanceCommand;
import com.fivestars.rocketnotes.students.interfaces.rest.resources.CreateAttendanceResource;

public class CreateAttendanceCommandFromResourceAssembler {
    public static CreateAttendanceCommand toCommandFromResource(CreateAttendanceResource resource){
           return new CreateAttendanceCommand(resource.studentId(),resource.courseId(),resource.date(),resource.isPresent()
            );
        }
}
