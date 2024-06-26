package com.fivestars.rocketnotes.admins.application.internal.queryservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Course;
import com.fivestars.rocketnotes.admins.domain.services.CourseQueryService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQueryServiceImpl implements CourseQueryService{

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
}
