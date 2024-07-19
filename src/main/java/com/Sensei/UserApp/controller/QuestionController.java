package com.Sensei.UserApp.controller;

import com.Sensei.UserApp.entity.Questions;
import com.Sensei.UserApp.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public List<Questions> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questions> findById(@PathVariable Long id) {
        return questionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Questions> create(@Valid @RequestBody Questions questions) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.save(questions));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questions> update(@PathVariable Long id, @Valid @RequestBody Questions questions) {
        if (!questionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        questions.setQuestionId(id);
        return ResponseEntity.ok(questionService.save(questions));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!questionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        questionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
