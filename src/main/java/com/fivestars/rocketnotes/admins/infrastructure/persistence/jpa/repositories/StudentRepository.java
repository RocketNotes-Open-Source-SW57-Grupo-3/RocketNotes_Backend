package com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories;

import com.fivestars.rocketnotes.admins.domain.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}