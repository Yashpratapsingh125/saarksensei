package com.Sensei.UserApp.controller;


import com.Sensei.UserApp.entity.Activity;
import com.Sensei.UserApp.service.ActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @GetMapping
    public List<Activity> findAll() {
        return activityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> findById(@PathVariable Long id) {
        return activityService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Activity> create(@Valid @RequestBody Activity activity) {
        System.out.println(activity+" this is activity");
        return ResponseEntity.status(HttpStatus.CREATED).body(activityService.save(activity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> update(@PathVariable Long id, @Valid @RequestBody Activity activity) {
        if (!activityService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        activity.setActivityId(id);
        return ResponseEntity.ok(activityService.save(activity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!activityService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        activityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
