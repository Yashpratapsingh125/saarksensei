package com.Sensei.UserApp.controller;

import com.Sensei.UserApp.entity.SubModule;
import com.Sensei.UserApp.service.SubModuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submodules")
@RequiredArgsConstructor
public class SubModuleController {
    private final SubModuleService subModuleService;

    @GetMapping
    public List<SubModule> findAll() {
        return subModuleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubModule> findById(@PathVariable Long id) {
        return subModuleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SubModule> create(@Valid @RequestBody SubModule subModule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subModuleService.save(subModule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubModule> update(@PathVariable Long id, @Valid @RequestBody SubModule subModule) {
        if (!subModuleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        subModule.setSubModuleId(id);
        return ResponseEntity.ok(subModuleService.save(subModule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!subModuleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        subModuleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
