package com.engineerLiberty.techieAssessment.controller;

import com.engineerLiberty.techieAssessment.model.Score;
import com.engineerLiberty.techieAssessment.model.Student;
import com.engineerLiberty.techieAssessment.repository.StudentRepository;
import com.engineerLiberty.techieAssessment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/submit")
    @Transactional
    public String submitStudentScores(@ModelAttribute Student student) {

        student.getScores().forEach(score -> score.setStudent(student));
        System.out.println("Received student: " + student);
        System.out.println("Scores: " + student.getScores());


        if (student.getScores() != null) {
            student.getScores().forEach(score -> score.setStudent(student));
        }

        studentRepository.save(student);
        return "redirect:/report";
    }


    @GetMapping("/report")
    public String showReport(Model model) {
        List<Student> students = studentService.getAllStudents();

        for (Student student : students) {
            if (student.getScores() == null) {
                student.setScores(new ArrayList<>());
            }
        }
        Map<Student, Double> studentMeans = studentService.getStudentMeans();
        Map<Student, Double> studentMedians = new HashMap<>();
        Map<Student, Integer> studentModes = new HashMap<>();

        // Calculate the median and mode for each student
        for (Student student : students) {
            double median = 0.0;
            int mode = 0;
            if (student.getScores() != null && !student.getScores().isEmpty()) {
                median = studentService.calculateMedian(student.getScores().get(0));
                mode = studentService.calculateMode(student.getScores().get(0));
            }
            studentMedians.put(student, median);
            studentModes.put(student, mode);
        }

        model.addAttribute("students", students);
        model.addAttribute("studentMeans", studentMeans);
        model.addAttribute("studentMedians", studentMedians);
        model.addAttribute("studentModes", studentModes);

        return "report";
    }
}
