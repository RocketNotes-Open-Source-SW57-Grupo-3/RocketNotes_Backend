package com.fivestars.rocketnotes.admins.interfaces.rest.resources;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentResource {
    private Long id;
    private String firstName;
    private String paternalLastName;
    private String maternalLastName;
    private String dni;
    private List<Long> classrooms;
}