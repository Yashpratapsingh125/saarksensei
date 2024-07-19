package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.Processes;

import java.util.List;
import java.util.Optional;

public interface ProcessService {
    List<Processes> findAll();
    Optional<Processes> findById(Long id);
    Processes save(Processes processes);
    void deleteById(Long id);

}
