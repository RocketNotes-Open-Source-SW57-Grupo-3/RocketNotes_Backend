package com.fivestars.rocketnotes.students.interfaces.rest.transform;

import com.fivestars.rocketnotes.students.domain.model.commands.CreateGradeCommand;
import com.fivestars.rocketnotes.students.interfaces.rest.resources.CreateGradeResource;

public class CreateGradeCommandFromResourceAssembler {
    public static CreateGradeCommand toCommandFromResource(CreateGradeResource resource){
        return new CreateGradeCommand(
            resource.studentId(),
            resource.courseId(),
            resource.grade()
        );
    }
}
