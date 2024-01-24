package com.example.final_project_2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Offer implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private Duration DurationOfWork;
    private LocalDate SuggestedTimeToStartWork;
    @NotBlank
    private double RecommendedPrice;
    private LocalDate dateRegisterOffer;
    @ManyToOne
    private Expert expert;

    @ManyToOne
    private Order order;




}
