package com.fivestars.rocketnotes.Maintenance.interfaces.rest;


import com.fivestars.rocketnotes.Maintenance.domain.model.queries.GetFacilitieByIdQuery;
import com.fivestars.rocketnotes.Maintenance.domain.services.FacilitieCommandService;
import com.fivestars.rocketnotes.Maintenance.domain.services.FacilitieQueryService;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.CreateFacilitieResource;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources.FacilitieResource;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform.CreateFacilitieCommandFromResourceAssembler;
import com.fivestars.rocketnotes.Maintenance.interfaces.rest.transform.FacilitieResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/factilites", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Facilities", description = "Facilitie Management Endpoint")
public class FacilitieController {
    private final FacilitieQueryService facilitieQueryService;
    private final FacilitieCommandService facilitieCommandService;

    public FacilitieController(FacilitieCommandService facilitieCommandService, FacilitieQueryService facilitieQueryService){
        this.facilitieCommandService = facilitieCommandService;
        this.facilitieQueryService = facilitieQueryService;
    }

    @PostMapping
    public ResponseEntity<FacilitieResource> createFacilitie(@RequestBody CreateFacilitieResource resource){
        var command = CreateFacilitieCommandFromResourceAssembler.toCommandFromResource(resource);
        var facilitieId = facilitieCommandService.handle(command);
        if(facilitieId==0L) return ResponseEntity.badRequest().build();
        var getFacilitieByIdQuery = new GetFacilitieByIdQuery(facilitieId);
        var facilitie = facilitieQueryService.handle(getFacilitieByIdQuery);
        if(facilitie.isEmpty()) return ResponseEntity.badRequest().build();
        var facilitieResource = FacilitieResourceFromEntityAssembler.toResourceFromEntity(facilitie.get());
        return new ResponseEntity<>(facilitieResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilitieResource> getFacilitieById(@PathVariable Long id){
        var getFacilitieByIdQuery = new GetFacilitieByIdQuery(id);
        var facilitie = facilitieQueryService.handle(getFacilitieByIdQuery);
        if(facilitie.isEmpty()) return ResponseEntity.badRequest().build();
        var facilitieResource = FacilitieResourceFromEntityAssembler.toResourceFromEntity(facilitie.get());
        return ResponseEntity.ok(facilitieResource);
    }

}
