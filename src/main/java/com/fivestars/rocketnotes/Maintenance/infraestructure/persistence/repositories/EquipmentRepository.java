package com.fivestars.rocketnotes.Maintenance.infraestructure.persistence.repositories;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
