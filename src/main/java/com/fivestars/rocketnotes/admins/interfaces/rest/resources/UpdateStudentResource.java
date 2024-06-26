package com.fivestars.rocketnotes.admins.interfaces.rest.resources;

import lombok.Data;

@Data
public class UpdateStudentResource {
    private String firstName;
    private String paternalLastName;
    private String maternalLastName;
    private String dni;
}
