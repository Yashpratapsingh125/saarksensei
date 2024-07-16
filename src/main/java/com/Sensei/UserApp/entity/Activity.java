package com.Sensei.UserApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @NotBlank
    private String activityName;

    @NotBlank
    private String activityType;

    private String image;

    @NotBlank
    private String activityNumber;

    private String ratings;

    private String tags;

    @ManyToOne
    @JoinColumn(name = "sub_module_id")
    private SubModule subModule;
}

