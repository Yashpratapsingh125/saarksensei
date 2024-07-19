package com.Sensei.UserApp.controller;

import com.Sensei.UserApp.entity.Processes;
import com.Sensei.UserApp.service.ProcessService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
@RequiredArgsConstructor
public class ProcessController {
    private final ProcessService processService;

    @GetMapping
    public List<Processes> findAll() {
        return processService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Processes> findById(@PathVariable Long id) {
        return processService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Processes> create(@Valid @RequestBody Processes processes) {
        return ResponseEntity.status(HttpStatus.CREATED).body(processService.save(processes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Processes> update(@PathVariable Long id, @Valid @RequestBody Processes processes) {
        if (!processService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processes.setProcessId(id);
        return ResponseEntity.ok(processService.save(processes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!processService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
