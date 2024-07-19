package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.Processes;
import com.Sensei.UserApp.repository.PorcessesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {
    private final PorcessesRepository porcessesRepository;

    @Override
    public List<Processes> findAll() {
        return porcessesRepository.findAll();
    }

    @Override
    public Optional<Processes> findById(Long id) {
        return porcessesRepository.findById(id);
    }

    @Override
    public Processes save(Processes processes) {
        return porcessesRepository.save(processes);
    }

    @Override
    public void deleteById(Long id) {
        porcessesRepository.deleteById(id);
    }
}
