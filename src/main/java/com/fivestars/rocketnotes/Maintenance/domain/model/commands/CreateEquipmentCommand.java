package com.fivestars.rocketnotes.Maintenance.domain.model.commands;


public record CreateEquipmentCommand(String name, int quantity, int budget,String creation, String period) {
}
