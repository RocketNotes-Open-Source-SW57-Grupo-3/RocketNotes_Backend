package com.fivestars.rocketnotes.students.domain.model.aggregates;

import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private StudentId studentId;

    @Embedded
    private CourseId courseId;

    @Column(nullable = false)
    private int grade;

    public Grade() {}

    public Grade(StudentId studentId, CourseId courseId, int grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }
}
