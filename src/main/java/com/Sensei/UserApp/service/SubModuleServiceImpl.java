package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.SubModule;
import com.Sensei.UserApp.repository.SubModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubModuleServiceImpl implements SubModuleService {
    private final SubModuleRepository subModuleRepository;

    @Override
    public List<SubModule> findAll() {
        return subModuleRepository.findAll();
    }

    @Override
    public Optional<SubModule> findById(Long id) {
        return subModuleRepository.findById(id);
    }

    @Override
    public SubModule save(SubModule subModule) {
        return subModuleRepository.save(subModule);
    }

    @Override
    public void deleteById(Long id) {
        subModuleRepository.deleteById(id);
    }
}
