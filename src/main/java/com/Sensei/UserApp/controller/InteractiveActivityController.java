package com.Sensei.UserApp.controller;

import com.Sensei.UserApp.entity.InteractiveActivity;
import com.Sensei.UserApp.service.InteractiveActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/interactiveActivities")
@RequiredArgsConstructor
public class InteractiveActivityController {
    private final InteractiveActivityService interactiveActivityService;

    @GetMapping
    public List<InteractiveActivity> findAll() {
        return interactiveActivityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteractiveActivity> findById(@PathVariable Long id) {
        return interactiveActivityService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InteractiveActivity> create(@Valid @RequestBody InteractiveActivity interactiveActivity) {
        System.out.println(interactiveActivity+" this is interactive Activity");
        return ResponseEntity.status(HttpStatus.CREATED).body(interactiveActivityService.save(interactiveActivity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InteractiveActivity> update(@PathVariable Long id, @Valid @RequestBody InteractiveActivity interactiveActivity) {
        if (!interactiveActivityService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        interactiveActivity.setInteractiveActivityId(id);
        return ResponseEntity.ok(interactiveActivityService.save(interactiveActivity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!interactiveActivityService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        interactiveActivityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
