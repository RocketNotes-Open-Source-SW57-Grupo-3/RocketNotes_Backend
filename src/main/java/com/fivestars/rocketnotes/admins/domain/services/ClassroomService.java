package com.fivestars.rocketnotes.admins.domain.services;



import com.fivestars.rocketnotes.admins.domain.model.entities.Classroom;
import com.fivestars.rocketnotes.admins.domain.model.entities.Student;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.ClassroomRepository;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom updateClassroom(Long id, Classroom classroomDetails) {
        Classroom classroom = classroomRepository.findById(id).orElse(null);
        if (classroom != null) {
            classroom.setName(classroomDetails.getName());
            classroom.setSection(classroomDetails.getSection());
            classroom.setCapacity(classroomDetails.getCapacity());
            return classroomRepository.save(classroom);
        }
        return null;
    }

    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }

    public Classroom addStudentToClassroom(Long classroomId, Long studentId) {
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);
        if (classroom != null && student != null) {
            classroom.getStudents().add(student);
            return classroomRepository.save(classroom);
        }
        return null;
    }

    public Classroom removeStudentFromClassroom(Long classroomId, Long studentId) {
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);
        if (classroom != null && student != null) {
            classroom.getStudents().remove(student);
            return classroomRepository.save(classroom);
        }
        return null;
    }
}
