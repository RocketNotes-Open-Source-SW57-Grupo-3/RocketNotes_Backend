package com.fivestars.rocketnotes.Maintenance.domain.exceptions;

public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(Long aLong) { super("Could not find equipment with" + aLong ); }
}
