package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.InteractiveActivity;

import java.util.List;
import java.util.Optional;

public interface InteractiveActivityService {
    List<InteractiveActivity> findAll();
    Optional<InteractiveActivity> findById(Long id);
    InteractiveActivity save(InteractiveActivity interactiveActivity);
    void deleteById(Long id);
}
