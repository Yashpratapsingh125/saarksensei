package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.DigitalActivity;
import com.Sensei.UserApp.repository.DigitalActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DigitalActivityServiceImpl implements DigitalActivityService {
    private final DigitalActivityRepository digitalActivityRepository;

    @Override
    public List<DigitalActivity> findAll() {
        return digitalActivityRepository.findAll();
    }

    @Override
    public Optional<DigitalActivity> findById(Long id) {
        return digitalActivityRepository.findById(id);
    }

    @Override
    public DigitalActivity save(DigitalActivity digitalActivity) {
        return digitalActivityRepository.save(digitalActivity);
    }

    @Override
    public void deleteById(Long id) {
        digitalActivityRepository.deleteById(id);
    }
}