package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.Questions;
import com.Sensei.UserApp.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    private final QuestionsRepository questionsRepository;

    @Override
    public List<Questions> findAll() {
        return questionsRepository.findAll();
    }

    @Override
    public Optional<Questions> findById(Long id) {
        return questionsRepository.findById(id);
    }

    @Override
    public Questions save(Questions questions) {
        return questionsRepository.save(questions);
    }

    @Override
    public void deleteById(Long id) {
        questionsRepository.deleteById(id);
    }
}
