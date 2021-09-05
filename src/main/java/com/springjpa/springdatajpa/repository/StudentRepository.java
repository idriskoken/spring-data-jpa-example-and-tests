package com.springjpa.springdatajpa.repository;

import com.springjpa.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String name);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName, String lastName);
    @Query( "select s from Student s where s.emailId = ?1" )
    Student getStudentByEmailAddress(String emailId);

    @Query( "select s.firstName from Student s where s.emailId = ?1" )
    String getStudentFirstNameByEmailAddress(String emailId);

    @Query(
            value = "Select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String EmailId);

    @Query(
            value = "select * from tbl_student s where s.email_address = _emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmail(String firstName, String emailId);
}
