package com.fivestars.rocketnotes.Maintenance.domain.model.commands;


public record CreateEquipmentCommand(String name, Integer quantity, Integer budget,String creation, String period) {
}
