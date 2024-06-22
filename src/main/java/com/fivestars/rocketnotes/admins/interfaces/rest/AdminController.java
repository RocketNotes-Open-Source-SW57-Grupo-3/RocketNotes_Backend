package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Admin;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateAdminCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteAdminCommand;
import com.fivestars.rocketnotes.admins.domain.services.AdminCommandService;
import com.fivestars.rocketnotes.admins.domain.services.AdminQueryService;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.AdminResource;
import com.fivestars.rocketnotes.admins.interfaces.rest.resources.CreateAdminResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminCommandService adminCommandService;
    private final AdminQueryService adminQueryService;

    @PostMapping
    public Long createAdmin(@RequestBody CreateAdminResource createAdminResource) {
        CreateAdminCommand command = new CreateAdminCommand(
                createAdminResource.getFirstName(),
                createAdminResource.getLastName(),
                createAdminResource.getEmail(),
                createAdminResource.getPassword()
        );
        return adminCommandService.handle(command);
    }

    @GetMapping
    public List<AdminResource> getAllAdmins() {
        return adminQueryService.getAllAdmins().stream()
                .map(admin -> AdminResource.builder()
                        .id(admin.getId())
                        .firstName(admin.getFirstName())
                        .lastName(admin.getLastName())
                        .email(admin.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AdminResource getAdminById(@PathVariable Long id) {
        Admin admin = adminQueryService.getAdminById(id);
        return AdminResource.builder()
                .id(admin.getId())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .email(admin.getEmail())
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteAdmin(@PathVariable Long adminId) {
        adminCommandService.handle(new DeleteAdminCommand(adminId));
        return ResponseEntity.ok().build();
    }


}