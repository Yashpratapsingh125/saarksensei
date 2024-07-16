package com.Sensei.UserApp.controller;

import com.Sensei.UserApp.entity.Subject;
import com.Sensei.UserApp.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public List<Subject> findAll() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> findById(@PathVariable Long id) {
        return subjectService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Subject> create(@Valid @RequestBody Subject subject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.save(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> update(@PathVariable Long id, @Valid @RequestBody Subject subject) {
        if (!subjectService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        subject.setSubjectId(id);
        return ResponseEntity.ok(subjectService.save(subject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!subjectService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        subjectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

