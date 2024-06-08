package com.fivestars.rocketnotes.Maintenance.domain.services;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Facilitie;
import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetAllFacilitiesQuery;
import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetFacilitieByIdQuery;

import java.util.List;
import java.util.Optional;

public interface FacilitieQueryService {

    Optional<Facilitie> handle(GetFacilitieByIdQuery query);
    List<Facilitie> handle(GetAllFacilitiesQuery query);

}
