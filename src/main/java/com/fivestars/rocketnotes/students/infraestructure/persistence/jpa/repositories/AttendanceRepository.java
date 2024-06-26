package com.fivestars.rocketnotes.students.infraestructure.persistence.jpa.repositories;

import com.fivestars.rocketnotes.students.domain.model.aggregates.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}