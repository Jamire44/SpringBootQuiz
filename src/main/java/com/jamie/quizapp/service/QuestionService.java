package com.jamie.quizapp.service;

import com.jamie.quizapp.model.Questions;
import com.jamie.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Questions>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionByCategory(String category){
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Questions questions) {
        questionDao.save(questions);
        try {
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Couldn't Add Question",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        try {
            return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Could not delete", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Questions questions, Integer id) {
        questionDao.save(questions);
        try {
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Could not update", HttpStatus.BAD_REQUEST);

    }
}//class
