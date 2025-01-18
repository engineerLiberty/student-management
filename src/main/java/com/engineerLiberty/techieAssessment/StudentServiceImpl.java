package com.engineerLiberty.techieAssessment;

import com.engineerLiberty.techieAssessment.model.Score;
import com.engineerLiberty.techieAssessment.model.Student;
import com.engineerLiberty.techieAssessment.repository.StudentRepository;
import com.engineerLiberty.techieAssessment.service.StudentService;
import lombok.RequiredArgsConstructor;
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
        return (score.getSubject1() + score.getSubject2() + score.getSubject3() + score.getSubject4() + score.getSubject5()) / 5.0;
    }

    public double calculateMedian(Score score) {
        if (score == null) return 0.0;

        List<Integer> scores = Arrays.asList(score.getSubject1(), score.getSubject2(), score.getSubject3(), score.getSubject4(), score.getSubject5());
        Collections.sort(scores);
        return scores.get(2); // Middle value in sorted list (since there are 5 subjects)
    }

    public int calculateMode(Score score) {
        if (score == null) return 0;

        Map<Integer, Long> frequencyMap = new HashMap<>();
        List<Integer> scoreList = Arrays.asList(score.getSubject1(), score.getSubject2(), score.getSubject3(), score.getSubject4(), score.getSubject5());

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
            total += score.getSubject1() + score.getSubject2() + score.getSubject3() + score.getSubject4() + score.getSubject5();
            subjectCount += 5;  // Assuming 5 subjects for each Score
        }

        return total / subjectCount;
    }

    public double calculateMedian(List<Score> scores) {
        if (scores == null || scores.isEmpty()) return 0.0;

        List<Integer> allScores = new ArrayList<>();

        for (Score score : scores) {
            allScores.add(score.getSubject1());
            allScores.add(score.getSubject2());
            allScores.add(score.getSubject3());
            allScores.add(score.getSubject4());
            allScores.add(score.getSubject5());
        }

        Collections.sort(allScores);
        return allScores.get(allScores.size() / 2); // Return the middle value after sorting
    }

    public int calculateMode(List<Score> scores) {
        if (scores == null || scores.isEmpty()) return 0;

        Map<Integer, Long> frequencyMap = new HashMap<>();

        for (Score score : scores) {
            frequencyMap.put(score.getSubject1(), frequencyMap.getOrDefault(score.getSubject1(), 0L) + 1);
            frequencyMap.put(score.getSubject2(), frequencyMap.getOrDefault(score.getSubject2(), 0L) + 1);
            frequencyMap.put(score.getSubject3(), frequencyMap.getOrDefault(score.getSubject3(), 0L) + 1);
            frequencyMap.put(score.getSubject4(), frequencyMap.getOrDefault(score.getSubject4(), 0L) + 1);
            frequencyMap.put(score.getSubject5(), frequencyMap.getOrDefault(score.getSubject5(), 0L) + 1);
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
