package com.fivestars.rocketnotes.Maintenance.domain.exceptions;

public class FacilitieNotFoundException extends RuntimeException {
    public FacilitieNotFoundException(Long aLong) {super("Could not find equipment with" + aLong );}
}
