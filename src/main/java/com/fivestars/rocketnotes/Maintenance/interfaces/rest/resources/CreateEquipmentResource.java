package com.fivestars.rocketnotes.Maintenance.interfaces.rest.resources;

public record CreateEquipmentResource(String name, int quantity, int budget, String creation, String period, int status) {
}
