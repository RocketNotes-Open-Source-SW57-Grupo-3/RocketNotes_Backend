package com.fivestars.rocketnotes.admins.domain.model.commands;


import java.util.List;

public record CreateStudentCommand(String firstName, String paternalLastName, String maternalLastName, String dni, List<Long> classrooms) {}

