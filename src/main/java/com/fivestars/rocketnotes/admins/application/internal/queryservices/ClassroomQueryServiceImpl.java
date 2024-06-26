package com.fivestars.rocketnotes.admins.application.internal.queryservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Classroom;
import com.fivestars.rocketnotes.admins.domain.services.ClassroomQueryService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomQueryServiceImpl implements ClassroomQueryService {
    private final ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }
}
