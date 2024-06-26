package com.fivestars.rocketnotes.students.interfaces.rest.transform;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Grade;
import com.fivestars.rocketnotes.students.interfaces.rest.resources.GradeResource;

public class GradeResourceFromEntityAssembler {
    public static GradeResource toResourceFromEntity(Grade grade){
        return new GradeResource (
            grade.getStudentId(),
            grade.getCourseId(),
            grade.getGrade()
        );
    }

}
