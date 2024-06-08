package com.fivestars.rocketnotes.admins.interfaces.rest;

import com.fivestars.rocketnotes.admins.domain.model.entities.Classroom;
import com.fivestars.rocketnotes.admins.domain.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public Classroom getClassroomById(@PathVariable Long id) {
        return classroomService.getClassroomById(id);
    }

    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classroomService.createClassroom(classroom);
    }

    @PutMapping("/{id}")
    public Classroom updateClassroom(@PathVariable Long id, @RequestBody Classroom classroomDetails) {
        return classroomService.updateClassroom(id, classroomDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
    }

    @PostMapping("/{classroomId}/students/{studentId}")
    public Classroom addStudentToClassroom(@PathVariable Long classroomId, @PathVariable Long studentId) {
        return classroomService.addStudentToClassroom(classroomId, studentId);
    }

    @DeleteMapping("/{classroomId}/students/{studentId}")
    public Classroom removeStudentFromClassroom(@PathVariable Long classroomId, @PathVariable Long studentId) {
        return classroomService.removeStudentFromClassroom(classroomId, studentId);
    }
}