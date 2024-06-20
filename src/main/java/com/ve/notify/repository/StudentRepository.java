package com.ve.notify.repository;

import com.ve.notify.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findBySubjectAndLocation(String subject, String location);
    List<Student> findByLocation(String location);
}