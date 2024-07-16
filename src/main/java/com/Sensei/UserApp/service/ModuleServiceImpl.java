package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.Module;
import com.Sensei.UserApp.repository.ModuleRepository;

import com.Sensei.UserApp.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;

    @Override
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Optional<Module> findById(Long id) {
        return moduleRepository.findById(id);
    }

    @Override
    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public void deleteById(Long id) {
        moduleRepository.deleteById(id);
    }
}
