package com.fivestars.rocketnotes.Maintenance.application.internal.commandservices;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Equipment;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateEquipmentCommand;
import com.fivestars.rocketnotes.Maintenance.domain.services.EquipmentCommandService;
import com.fivestars.rocketnotes.Maintenance.infraestructure.persistence.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Long handle(CreateEquipmentCommand command) {
        Equipment equipment = new Equipment(command.name(),command.quantity(),command.budget(), command.creation(), command.period());
        equipmentRepository.save(equipment);
        return equipment.getId();
    }
}
