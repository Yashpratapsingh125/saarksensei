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
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    @NotBlank
    private String moduleName;

    @NotBlank
    private String moduleIntro;

    private int moduleNumber;

    @NotBlank
    private String moduleOutcome;

    @NotBlank
    private String moduleDescription;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
