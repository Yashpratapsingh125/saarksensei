package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.DigitalActivity;

import java.util.List;
import java.util.Optional;

public interface DigitalActivityService {
    List<DigitalActivity> findAll();
    Optional<DigitalActivity> findById(Long id);
    DigitalActivity save(DigitalActivity digitalActivity);
    void deleteById(Long id);
}