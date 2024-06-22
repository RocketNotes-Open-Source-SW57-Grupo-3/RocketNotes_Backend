package com.fivestars.rocketnotes.Maintenance.application.internal.commandservices;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Equipment;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.CreateEquipmentCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.DeleteEquipmentByIdCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.commands.UpdateEquipmentCommand;
import com.fivestars.rocketnotes.Maintenance.domain.services.EquipmentCommandService;
import com.fivestars.rocketnotes.Maintenance.infraestructure.persistence.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Override
    public void handle(DeleteEquipmentByIdCommand command) {
        if (!equipmentRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Equipment does not exist");
        }
        try {
            equipmentRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting equipment: " + e.getMessage());
        }
    }

@Override
public Optional<Equipment> handle(UpdateEquipmentCommand command) {
    Optional<Equipment> result = equipmentRepository.findById(command.id());

    if (result.isEmpty()) {
        throw new IllegalArgumentException("Equipment does not exist");
    }

    Equipment equipmentToUpdate = result.get();

    // Verificar si existe otro equipo con el mismo nombre
    Optional<Equipment> equipmentWithSameName = equipmentRepository.findByName(command.name());
    if (equipmentWithSameName.isPresent() && !equipmentWithSameName.get().getId().equals(command.id())) {
        throw new IllegalArgumentException("Equipment with same name already exists");
    }

    // Actualizar la información del equipo
    equipmentToUpdate.setName(command.name());
    equipmentToUpdate.setQuantity(command.quantity());
    equipmentToUpdate.setBudget(command.budget());
    equipmentToUpdate.setCreation(command.creation());
    equipmentToUpdate.setPeriod(command.period());

    try {
        Equipment updatedEquipment = equipmentRepository.save(equipmentToUpdate);
        return Optional.of(updatedEquipment);
    } catch (Exception e) {
        throw new IllegalArgumentException("Error while updating equipment: " + e.getMessage());
    }
}
}
