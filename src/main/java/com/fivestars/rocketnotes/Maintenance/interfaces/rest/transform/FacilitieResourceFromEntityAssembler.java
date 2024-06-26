package com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Facilitie;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.FacilitieResource;

public class FacilitieResourceFromEntityAssembler {
    public static FacilitieResource toResourceFromEntity(Facilitie facilitie){
        return new FacilitieResource(
                facilitie.getId(),
                facilitie.getName(),
                facilitie.getBudget(),
                facilitie.getCreation(),
                facilitie.getPeriod(),
                facilitie.getStatus()
        );
    }
}
