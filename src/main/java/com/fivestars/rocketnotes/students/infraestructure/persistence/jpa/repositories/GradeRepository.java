package com.fivestars.rocketnotes.students.infraestructure.persistence.jpa.repositories;


import com.fivestars.rocketnotes.students.domain.model.aggregates.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}