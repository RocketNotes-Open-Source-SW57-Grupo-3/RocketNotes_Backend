package com.fivestars.rocketnotes.students.domain.model.aggregates;

import com.fivestars.rocketnotes.Maintenance.domain.model.valueobjects.EquipmentStatus;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.CourseId;
import com.fivestars.rocketnotes.students.domain.model.valueobjects.StudentId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
public class Attendance {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private StudentId studentId;

    @Embedded
    private CourseId courseId;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDateTime date;

    @Getter
    @Setter
    @Column(nullable = false)
    private boolean present;

    public Attendance() {

    }


    public Attendance(StudentId studentId,CourseId courseId, LocalDateTime date, boolean present) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
        this.present = present;
    }



}
