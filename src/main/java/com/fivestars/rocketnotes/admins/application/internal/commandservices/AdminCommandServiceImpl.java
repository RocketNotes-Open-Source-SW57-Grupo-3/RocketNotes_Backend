package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Admin;
import com.fivestars.rocketnotes.admins.domain.model.aggregates.Classroom;
import com.fivestars.rocketnotes.admins.domain.model.aggregates.Course;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateAdminCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteAdminCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.DeleteCourseCommand;
import com.fivestars.rocketnotes.admins.domain.services.AdminCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminCommandServiceImpl implements AdminCommandService {

    private final AdminRepository adminRepository;

    @Override
    public Long handle(CreateAdminCommand command) {
        Admin admin = new Admin(
                command.firstName(),
                command.lastName(),
                command.email(),
                command.password());
        adminRepository.save(admin);
        return admin.getId();
    }


    @Override
    public void handle(DeleteAdminCommand command) {
        Admin admin = adminRepository.findById(command.adminId()).orElseThrow(() -> new RuntimeException("Admin not found"));
        adminRepository.delete(admin);
    }
}