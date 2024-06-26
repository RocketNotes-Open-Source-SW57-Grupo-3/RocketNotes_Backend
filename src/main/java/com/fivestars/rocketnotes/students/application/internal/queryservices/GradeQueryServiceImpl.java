package com.fivestars.rocketnotes.students.application.internal.queryservices;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Grade;
import com.fivestars.rocketnotes.students.domain.model.queries.GetAllGradesForStudentQuery;
import com.fivestars.rocketnotes.students.domain.services.GradeQueryService;
import com.fivestars.rocketnotes.students.infraestructure.persistence.jpa.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeQueryServiceImpl implements GradeQueryService {

    private final GradeRepository gradeRepository;

    public GradeQueryServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }



    @Override
    public List<Grade> handle(GetAllGradesForStudentQuery query) {
        return gradeRepository.findAll();
    }
}