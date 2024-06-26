package com.fivestars.rocketnotes.profiles.domain.model.queries;

import com.fivestars.rocketnotes.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
