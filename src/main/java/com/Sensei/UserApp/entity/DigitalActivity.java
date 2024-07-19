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
public class DigitalActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long digitalActivityId;

    @NotBlank
    private String digitalActivityName;

    private String keyOutcomes;

    @NotBlank
    private String numberOfQuestion;

    private String image;

    @ManyToOne
    @JoinColumn(name = "activity")
    private Activity activity;
}
