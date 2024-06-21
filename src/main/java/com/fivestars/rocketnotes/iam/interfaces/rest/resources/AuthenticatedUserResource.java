package com.fivestars.rocketnotes.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}
