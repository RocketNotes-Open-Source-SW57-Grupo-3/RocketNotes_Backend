package com.fivestars.rocketnotes.profiles.domain.services;

import com.fivestars.rocketnotes.profiles.domain.model.aggregates.Profile;
import com.fivestars.rocketnotes.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommanService {
    Optional<Profile> handle(CreateProfileCommand command);
}
