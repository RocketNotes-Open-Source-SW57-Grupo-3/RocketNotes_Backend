package com.fivestars.rocketnotes.Maintenance.infraestructure.persistence.repositories;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Facilitie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilitieRepository extends JpaRepository<Facilitie,Long> {
}
