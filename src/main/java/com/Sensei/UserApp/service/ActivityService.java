package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<Activity> findAll();
    Optional<Activity> findById(Long id);
    Activity save(Activity activity);
    void deleteById(Long id);
}
