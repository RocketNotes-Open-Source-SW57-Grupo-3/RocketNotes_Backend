package com.fivestars.rocketnotes.Maintenance.application.internal.queryservices;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Facilitie;
import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetAllFacilitiesQuery;
import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetFacilitieByIdQuery;
import com.fivestars.rocketnotes.Maintenance.domain.services.FacilitieQueryService;
import com.fivestars.rocketnotes.Maintenance.infraestructure.persistence.repositories.FacilitieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilitieQueryServiceImpl implements FacilitieQueryService {
    private final FacilitieRepository facilitieRepository;

    public FacilitieQueryServiceImpl(FacilitieRepository facilitieRepository){
        this.facilitieRepository = facilitieRepository;
    }
    @Override
    public Optional<Facilitie> handle(GetFacilitieByIdQuery query) {
        return facilitieRepository.findById(query.id());
    }

    @Override
    public List<Facilitie> handle(GetAllFacilitiesQuery query) {
        return facilitieRepository.findAll();
    }
}
