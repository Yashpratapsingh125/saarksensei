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
public class InteractiveActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interactiveActivityId;

    @NotBlank
    private String interactiveActivityName;

    @NotBlank
    private String interactiveActivityNumber;

    private String intro;

    private String materialsRequired;

    private String keyOutcomes;

    @NotBlank
    private String howToDoIt;

    private String objective;

    private String process;

    private String duration;

    private String image;

    private Boolean submission;

    @ManyToOne
    @JoinColumn(name = "activity")
    private Activity activity;
}