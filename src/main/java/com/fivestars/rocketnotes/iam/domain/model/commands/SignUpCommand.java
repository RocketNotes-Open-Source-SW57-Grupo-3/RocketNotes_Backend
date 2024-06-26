package com.fivestars.rocketnotes.iam.domain.model.commands;



import com.fivestars.rocketnotes.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
