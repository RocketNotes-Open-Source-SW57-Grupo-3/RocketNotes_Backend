package com.fivestars.rocketnotes.admins.interfaces.rest.resources;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CourseResource {
    private Long id;
    private Long roomId;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private String days;
    private Long teacherId;
    private byte[] image;
}
