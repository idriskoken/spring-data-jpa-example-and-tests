package com.springjpa.springdatajpa.repository;

import com.springjpa.springdatajpa.entity.Guardian;
import com.springjpa.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void  saveStudent() {
        Student student = Student.builder()
                .emailId("abc@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoii")
                //.guardianName("Nikhil")
                //.guardianEmail("nikhil@gmail.com")
                //.guardianMobile("99933651455")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentwithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Deli")
                .email("deli@gmail.com")
                .mobile("2546987222")
                .build();

        Student student = Student.builder()
                .firstName("Ali")
                .lastName("Veli")
                .emailId("ali@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList =  studentRepository.findAll();
        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Ali");
        System.out.println("student with name : " + students);
    }
    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("li");
        System.out.println("student with name : " + students);
    }
    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> student = studentRepository.findByGuardianName("Deli");
        System.out.println("Students : " + student);
    }
    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("ali@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("ali@gmail.com");
        System.out.println("students firstName = " + firstName);
    }
    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("ali@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("ali@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmail() {
        studentRepository.updateStudentNameByEmail("ali", "ali@gmail.com");
    }
}