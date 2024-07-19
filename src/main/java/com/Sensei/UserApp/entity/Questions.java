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
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private int questionNumber;

    private String questionName;

    private String senseiQuestion;

    private String option1;

    private String option2;

    private String option3;

    private String senseiAnswer;

    private String correctAnswerDescription;

    private String incorrectAnswerDescription;

    private String questionImage;

    @ManyToOne
    @JoinColumn(name = "digital_activity_id")
    private DigitalActivity digitalActivity;

}
