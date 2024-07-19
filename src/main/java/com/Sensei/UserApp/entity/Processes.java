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
public class Processes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long processId;

    @NotBlank
    private String processName;

    @NotBlank
    private String processNumber;

    private String senseiMessage;

    private String parentMessage;

    private String image;

    @ManyToOne
    @JoinColumn(name = "interactive_activity_id")
    private InteractiveActivity interactiveActivity;

}