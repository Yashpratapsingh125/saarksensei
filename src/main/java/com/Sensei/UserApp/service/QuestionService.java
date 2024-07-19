package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.Questions;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Questions> findAll();
    Optional<Questions> findById(Long id);
    Questions save(Questions questions);
    void deleteById(Long id);

}
