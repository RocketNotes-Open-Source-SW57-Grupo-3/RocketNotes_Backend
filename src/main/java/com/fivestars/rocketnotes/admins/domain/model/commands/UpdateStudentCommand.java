package com.fivestars.rocketnotes.admins.domain.model.commands;

public record UpdateStudentCommand(Long id, String firstName, String paternalLastName, String maternalLastName, String dni) {}
