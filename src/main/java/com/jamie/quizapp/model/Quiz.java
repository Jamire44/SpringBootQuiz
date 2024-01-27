package com.jamie.quizapp.model;/* Created by: Jamie
 * Created on:{27/01/2024}
 * This is a program is:
 */

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Questions> questions;

}//class
