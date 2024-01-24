package com.example.final_project_2.service.dto;

import lombok.Getter;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

@Getter
public class OfferDto implements Serializable {
    private Duration DurationOfWork;
    private LocalDate SuggestedTimeToStartWork;
    private double RecommendedPrice;
    private LocalDate dateRegisterOffer;
}
