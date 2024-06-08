package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.entities.Course;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setName(courseDetails.getName());
            course.setStartDate(courseDetails.getStartDate());
            course.setEndDate(courseDetails.getEndDate());
            course.setDays(courseDetails.getDays());
            course.setTeacher(courseDetails.getTeacher());
            course.setClassroom(courseDetails.getClassroom());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course uploadCourseImage(Long courseId, String imagePath) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            course.setImagePath(imagePath);
            return courseRepository.save(course);
        }
        return null;
    }
}
