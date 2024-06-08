package com.fivestars.rocketnotes.Maintenance.application.internal.queryservices;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Equipment;
import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetAllEquipmentsQuery;
import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetEquipmentByIdQuery;
import com.fivestars.rocketnotes.Maintenance.domain.services.EquipmentQueryService;
import com.fivestars.rocketnotes.Maintenance.infraestructure.persistence.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentQueryServiceImpl(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }
    @Override
    public Optional<Equipment> handle(GetEquipmentByIdQuery query) {
        return equipmentRepository.findById(query.id());
    }

    @Override
    public List<Equipment> handle(GetAllEquipmentsQuery query) {
        return equipmentRepository.findAll();
    }
}
