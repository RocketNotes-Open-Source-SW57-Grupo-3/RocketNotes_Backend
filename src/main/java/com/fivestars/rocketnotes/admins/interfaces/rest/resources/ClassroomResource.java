package com.fivestars.rocketnotes.admins.interfaces.rest.resources;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassroomResource {
    private Long id;
    private String name;
    private String section;
    private int capacity;
}
