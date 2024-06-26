package com.fivestars.rocketnotes.admins.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String paternalLastName;
    private String maternalLastName;
    private String dni;
    private String phone;
    private String email;

    public Teacher(String firstName, String paternalLastName, String maternalLastName, String dni, String phone, String email) {
        this.firstName = firstName;
        this.paternalLastName = paternalLastName;
        this.maternalLastName = maternalLastName;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
    }
    public void updateDetails(String firstName, String paternalLastName, String maternalLastName, String dni, String phone, String email) {
        this.firstName = firstName;
        this.paternalLastName = paternalLastName;
        this.maternalLastName = maternalLastName;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
    }
}