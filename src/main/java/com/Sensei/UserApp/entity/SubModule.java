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
public class SubModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subModuleId;

    @NotBlank
    private String subModuleName;

    private int subModuleNumber;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;
}


