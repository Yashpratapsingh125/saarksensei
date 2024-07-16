package com.Sensei.UserApp.controller;

import com.Sensei.UserApp.service.ModuleService;
import com.Sensei.UserApp.entity.Module;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping
    public List<Module> findAll() {
        return moduleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> findById(@PathVariable Long id) {
        return moduleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Module> create(@Valid @RequestBody Module module) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.save(module));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> update(@PathVariable Long id, @Valid @RequestBody Module module) {
        if (!moduleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        module.setModuleId(id);
        return ResponseEntity.ok(moduleService.save(module));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!moduleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        moduleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
