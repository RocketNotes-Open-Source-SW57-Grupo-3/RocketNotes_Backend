package com.fivestars.rocketnotes.students.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CourseId(Long CourseId) {
    public CourseId {
        if (CourseId < 0) {
            throw new IllegalArgumentException("CourseId cannot be negative");
        }
    }

    public CourseId() {
        this(0L);
    }
}
