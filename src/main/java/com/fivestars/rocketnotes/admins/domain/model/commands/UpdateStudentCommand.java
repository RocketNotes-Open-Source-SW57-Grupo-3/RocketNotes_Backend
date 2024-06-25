package com.fivestars.rocketnotes.admins.domain.model.commands;

public record UpdateStudentCommand(Long studentId, String firstName, String paternalLastName, String maternalLastName, String dni) {}
