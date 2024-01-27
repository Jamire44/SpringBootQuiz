package com.jamie.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;



}//class
