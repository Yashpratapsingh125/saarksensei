package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> findAll();
    Optional<Subject> findById(Long id);
    Subject save(Subject subject);
    void deleteById(Long id);
}
