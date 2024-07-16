package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.InteractiveActivity;
import com.Sensei.UserApp.repository.InteractiveActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class InteractiveActivityServiceImpl implements InteractiveActivityService{
    private final InteractiveActivityRepository interactiveActivityRepository;

    @Override
    public List<InteractiveActivity> findAll() {
        return interactiveActivityRepository.findAll();
    }

    @Override
    public Optional<InteractiveActivity> findById(Long id) {
        return interactiveActivityRepository.findById(id);
    }

    @Override
    public InteractiveActivity save(InteractiveActivity interactiveActivity) {
        return interactiveActivityRepository.save(interactiveActivity);
    }

    @Override
    public void deleteById(Long id) {
        interactiveActivityRepository.deleteById(id);
    }
}