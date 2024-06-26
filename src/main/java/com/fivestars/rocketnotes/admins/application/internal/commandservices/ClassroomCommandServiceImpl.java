package com.fivestars.rocketnotes.admins.application.internal.commandservices;


import com.fivestars.rocketnotes.admins.domain.model.aggregates.Classroom;
import com.fivestars.rocketnotes.admins.domain.model.aggregates.Course;
import com.fivestars.rocketnotes.admins.domain.model.aggregates.Student;
import com.fivestars.rocketnotes.admins.domain.model.aggregates.Teacher;
import com.fivestars.rocketnotes.admins.domain.model.commands.*;
import com.fivestars.rocketnotes.admins.domain.services.ClassroomCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.ClassroomRepository;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.CourseRepository;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.StudentRepository;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassroomCommandServiceImpl implements ClassroomCommandService {

    private final ClassroomRepository roomRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @Override
    public Long handle(CreateClassroomCommand command) {
        Classroom room = new Classroom(command.name(), command.section(), command.capacity());
        roomRepository.save(room);
        return room.getId();
    }

    @Override
    public void handle(AddStudentToClassroomCommand command) {
        Classroom room = roomRepository.findById(command.roomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        Student student = studentRepository.findById(command.studentId()).orElseThrow(() -> new RuntimeException("Student not found"));
        room.addStudent(student);
        roomRepository.save(room);
    }

    @Override
    public void handle(RemoveStudentFromClassroomCommand command) {
        Classroom room = roomRepository.findById(command.roomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        Student student = studentRepository.findById(command.studentId()).orElseThrow(() -> new RuntimeException("Student not found"));
        room.removeStudent(student);
        roomRepository.save(room);
    }

    @Override
    public Long handle(CreateCourseCommand command) {
        Classroom room = roomRepository.findById(command.roomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        Teacher teacher = teacherRepository.findById(command.teacherId()).orElseThrow(() -> new RuntimeException("Teacher not found"));
        Course course = new Course(command.roomId(),command.name(), command.start(), command.end(), command.days(), teacher, command.image());
        room.addCourse(course);
        roomRepository.save(room);
        courseRepository.save(course);
        return course.getId();
    }

    @Override
    public void handle(DeleteCourseCommand command) {
        Classroom room = roomRepository.findById(command.roomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        Course course = courseRepository.findById(command.courseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        room.removeCourse(course);
        roomRepository.save(room);
        courseRepository.delete(course);
    }
}
