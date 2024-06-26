package com.fivestars.rocketnotes.admins.domain.model.commands;


import java.time.LocalDate;

public record CreateCourseCommand(Long roomId, String name, LocalDate start, LocalDate end, String days, Long teacherId, String image) {}
