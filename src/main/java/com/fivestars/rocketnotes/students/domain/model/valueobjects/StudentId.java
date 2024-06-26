package com.fivestars.rocketnotes.students.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StudentId(Long StudentId) {
    public StudentId {
        if (StudentId < 0) {
            throw new IllegalArgumentException("StudentId cannot be negative");
        }
    }

    public StudentId() {
        this(0L);
    }
}
