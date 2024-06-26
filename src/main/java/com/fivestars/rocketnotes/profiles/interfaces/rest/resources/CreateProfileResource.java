package com.fivestars.rocketnotes.profiles.interfaces.rest.resources;

public record CreateProfileResource(String firstName,
                                    String lastName,
                                    String email) {
}
