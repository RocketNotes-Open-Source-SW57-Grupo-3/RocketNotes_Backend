package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Course;

import java.util.List;

public interface CourseQueryService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
}
