package com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories;

import com.fivestars.rocketnotes.admins.domain.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}