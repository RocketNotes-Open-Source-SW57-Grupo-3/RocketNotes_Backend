package com.fivestars.rocketnotes.Maintenance.interfaces.rest;

import com.fivestars.rocketnotes.Maintenance.domain.model.commands.DeleteEquipmentByIdCommand;
import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetAllEquipmentsQuery;
import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetEquipmentByIdQuery;
import com.fivestars.rocketnotes.Maintenance.domain.services.EquipmentCommandService;
import com.fivestars.rocketnotes.Maintenance.domain.services.EquipmentQueryService;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.CreateEquipmentResource;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.EquipmentResource;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name ="Equipments", description = "Equipment Management Endpoint")
public class EquipmentController {
    private final EquipmentCommandService equipmentCommandService;
    private final EquipmentQueryService equipmentQueryService;

    public EquipmentController(EquipmentCommandService equipmentCommandService, EquipmentQueryService equipmentQueryService) {
        this.equipmentCommandService = equipmentCommandService;
        this.equipmentQueryService = equipmentQueryService;
    }

    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource){
        var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var equipmentId = equipmentCommandService.handle(createEquipmentCommand);
        if(equipmentId == null)
            return ResponseEntity.badRequest().build();
        var getEquipmentById = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentById);
        if(equipment.isEmpty()) return ResponseEntity.badRequest().build();
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EquipmentResource>> getAllEquipments(){
        var getAllEquipmentsQuery = new GetAllEquipmentsQuery();
        var equipments = equipmentQueryService.handle(getAllEquipmentsQuery);
        var equipmentsResources = equipments.stream().map(EquipmentResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(equipmentsResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentResource> getEquipmentById(@PathVariable Long id){
        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(id);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);
        if(equipment.isEmpty()) return ResponseEntity.badRequest().build();
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return ResponseEntity.ok(equipmentResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipmentById(@PathVariable Long id){
        var deleteEquipmentByIdCommand = new DeleteEquipmentByIdCommand(id);
        equipmentCommandService.handle(deleteEquipmentByIdCommand);
        return ResponseEntity.ok("Equipment deleted successfully");
    }

}
