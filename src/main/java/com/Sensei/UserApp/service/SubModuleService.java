package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.SubModule;

import java.util.List;
import java.util.Optional;

public interface SubModuleService {
    List<SubModule> findAll();

    Optional<SubModule> findById(Long id);

    SubModule save(SubModule subModule);

    void deleteById(Long id);
}
