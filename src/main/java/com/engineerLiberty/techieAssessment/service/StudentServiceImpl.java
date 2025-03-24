package com.engineerLiberty.techieAssessment.service;

import com.engineerLiberty.techieAssessment.model.Score;
import com.engineerLiberty.techieAssessment.model.Student;
import com.engineerLiberty.techieAssessment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public double calculateMean(Score score) {
        if (score == null) return 0.0;
        return (score.getEnglish() + score.getMathematics() + score.getPhysics() + score.getChemistry() + score.getBiology()) / 5.0;
    }

    public double calculateMedian(Score score) {
        if (score == null) return 0.0;

        List<Integer> scores = Arrays.asList(score.getEnglish(), score.getMathematics(), score.getPhysics(), score.getChemistry(), score.getBiology());
        Collections.sort(scores);
        return scores.get(2); // Middle value in sorted list (since there are 5 subjects)
    }

    public int calculateMode(Score score) {
        if (score == null) return 0;

        Map<Integer, Long> frequencyMap = new HashMap<>();
        List<Integer> scoreList = Arrays.asList(score.getEnglish(), score.getMathematics(), score.getPhysics(), score.getChemistry(), score.getBiology());

        for (Integer scoreValue : scoreList) {
            frequencyMap.put(scoreValue, frequencyMap.getOrDefault(scoreValue, 0L) + 1);
        }

        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }



    public double calculateMean(List<Score> scores) {
        if (scores == null || scores.isEmpty()) return 0.0;
        double total = 0;
        int subjectCount = 0;

        for (Score score : scores) {
            total += score.getEnglish() + score.getMathematics() + score.getPhysics() + score.getChemistry() + score.getBiology();
            subjectCount += 5;  // Assuming 5 subjects for each Score
        }

        return total / subjectCount;
    }

    public double calculateMedian(List<Score> scores) {
        if (scores == null || scores.isEmpty()) return 0.0;

        List<Integer> allScores = new ArrayList<>();

        for (Score score : scores) {
            allScores.add(score.getEnglish());
            allScores.add(score.getMathematics());
            allScores.add(score.getPhysics());
            allScores.add(score.getChemistry());
            allScores.add(score.getBiology());
        }

        Collections.sort(allScores);
        return allScores.get(allScores.size() / 2); // Return the middle value after sorting
    }

    public int calculateMode(List<Score> scores) {
        if (scores == null || scores.isEmpty()) return 0;

        Map<Integer, Long> frequencyMap = new HashMap<>();

        for (Score score : scores) {
            frequencyMap.put(score.getEnglish(), frequencyMap.getOrDefault(score.getEnglish(), 0L) + 1);
            frequencyMap.put(score.getMathematics(), frequencyMap.getOrDefault(score.getMathematics(), 0L) + 1);
            frequencyMap.put(score.getPhysics(), frequencyMap.getOrDefault(score.getPhysics(), 0L) + 1);
            frequencyMap.put(score.getChemistry(), frequencyMap.getOrDefault(score.getChemistry(), 0L) + 1);
            frequencyMap.put(score.getBiology(), frequencyMap.getOrDefault(score.getBiology(), 0L) + 1);
        }

        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Map<Student, Double> getStudentMeans() {
        List<Student> students = getAllStudents();
        Map<Student, Double> studentMeans = new HashMap<>();

        for (Student student : students) {
            if (student.getScores() != null) {
                double mean = calculateMean(student.getScores()); // Directly calculate the mean for all scores
                studentMeans.put(student, mean);
            }
        }
        return studentMeans;
    }

}
