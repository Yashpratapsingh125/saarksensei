package com.Sensei.UserApp.controller;

import com.Sensei.UserApp.entity.DigitalActivity;
import com.Sensei.UserApp.service.DigitalActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digitalActivities")
@RequiredArgsConstructor
public class DigitalActivityController {
    private final DigitalActivityService digitalActivityService;

    @GetMapping
    public List<DigitalActivity> findAll() {
        return digitalActivityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigitalActivity> findById(@PathVariable Long id) {
        return digitalActivityService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DigitalActivity> create(@Valid @RequestBody DigitalActivity digitalActivity) {
        System.out.println(digitalActivity+" this is digital activity");
        return ResponseEntity.status(HttpStatus.CREATED).body(digitalActivityService.save(digitalActivity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DigitalActivity> update(@PathVariable Long id, @Valid @RequestBody DigitalActivity digitalActivity) {
        if (!digitalActivityService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        digitalActivity.setDigitalActivityId(id);
        return ResponseEntity.ok(digitalActivityService.save(digitalActivity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!digitalActivityService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        digitalActivityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
