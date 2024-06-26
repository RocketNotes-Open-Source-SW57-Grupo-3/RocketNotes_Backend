package com.fivestars.rocketnotes.admins.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Long> classrooms;

    private String firstName;
    private String paternalLastName;
    private String maternalLastName;
    private String dni;


    public Student(String firstName, String paternalLastName, String maternalLastName, String dni, List<Long> classrooms) {
        this.firstName = firstName;
        this.paternalLastName = paternalLastName;
        this.maternalLastName = maternalLastName;
        this.dni = dni;
        this.classrooms = classrooms;
    }
}