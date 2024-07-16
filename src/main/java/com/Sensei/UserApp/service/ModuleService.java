package com.Sensei.UserApp.service;

import java.util.List;
import java.util.Optional;
import com.Sensei.UserApp.entity.Module;
public interface ModuleService {
    List<Module> findAll();
    Optional<Module> findById(Long id);
    Module save(Module module);
    void deleteById(Long id);
}
