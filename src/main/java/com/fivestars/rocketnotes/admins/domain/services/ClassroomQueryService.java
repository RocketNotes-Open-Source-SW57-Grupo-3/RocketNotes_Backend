package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Classroom;

import java.util.List;

public interface ClassroomQueryService {
    List<Classroom> getAllClassrooms();
}
