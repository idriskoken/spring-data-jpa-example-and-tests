package com.springjpa.springdatajpa.repository;

import com.springjpa.springdatajpa.entity.Course;
import com.springjpa.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("Dejavu")
                .credit(6)
                .build();

        Course course2 = Course.builder()
                .title("JAVA")
                .credit(5)
                .build();

        Teacher  teacher = Teacher.builder()
                .firstName("T1")
                .lastName("TL1")
                .courses(List.of(course, course2))
                .build();

        teacherRepository.save(teacher);
    }
}