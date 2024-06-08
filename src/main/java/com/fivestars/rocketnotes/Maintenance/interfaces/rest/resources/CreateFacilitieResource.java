package com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources;

public record CreateFacilitieResource(String name, int quantity, int budget, String creation, String period, int status) {
}
