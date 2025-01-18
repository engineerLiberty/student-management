package com.engineerLiberty.techieAssessment.repository;

import com.engineerLiberty.techieAssessment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
