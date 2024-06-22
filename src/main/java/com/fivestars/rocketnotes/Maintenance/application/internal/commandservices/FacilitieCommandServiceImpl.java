package com.fivestars.rocketnotes.Maintenance.application.internal.commandservices;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Facilitie;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateFacilitieCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.DeleteFacilitieByIdCommand;
import com.fivestars.rocketnotes.Maintenance.domain.services.FacilitieCommandService;
import com.fivestars.rocketnotes.Maintenance.infraestructure.persistence.repositories.FacilitieRepository;
import org.springframework.stereotype.Service;

@Service
public class FacilitieCommandServiceImpl implements FacilitieCommandService {
    private final FacilitieRepository facilitieRepository;

    public FacilitieCommandServiceImpl(FacilitieRepository facilitieRepository) {
        this.facilitieRepository = facilitieRepository;
    }
    @Override
    public Long handle(CreateFacilitieCommand command) {
        Facilitie facilitie = new Facilitie(command.name(),command.budget(),command.creation(), command.period());
        facilitieRepository.save(facilitie);
        return facilitie.getId();
    }
    @Override
    public void handle(DeleteFacilitieByIdCommand command) {
        if (!facilitieRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Facilitie does not exist");
        }
        try {
            facilitieRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting facilitie: " + e.getMessage());
        }
    }
}
