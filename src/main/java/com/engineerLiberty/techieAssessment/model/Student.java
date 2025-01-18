package com.engineerLiberty.techieAssessment.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Score> scores = new ArrayList<>();

    public List<Score> getScores() {
        return scores;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Long getId() {
        return id;
    }
}
