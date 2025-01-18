package com.engineerLiberty.techieAssessment.service;

import com.engineerLiberty.techieAssessment.model.Score;
import com.engineerLiberty.techieAssessment.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public List<Student> getAllStudents();

    public double calculateMean(Score score);

     double calculateMedian(Score score);

    public int calculateMode(Score score);
    public Map<Student, Double> getStudentMeans();
}
