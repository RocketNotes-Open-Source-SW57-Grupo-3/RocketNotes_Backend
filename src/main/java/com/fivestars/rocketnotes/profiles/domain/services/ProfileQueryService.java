package com.fivestars.rocketnotes.profiles.domain.services;

import com.fivestars.rocketnotes.profiles.domain.model.aggregates.Profile;
import com.fivestars.rocketnotes.profiles.domain.model.queries.GetAllProfilesQuery;
import com.fivestars.rocketnotes.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.fivestars.rocketnotes.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
    List<Profile> handle(GetAllProfilesQuery query);
}
