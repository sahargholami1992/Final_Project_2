package com.example.final_project_2.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class OfferDto implements Serializable {
    private int DurationOfWork;
    private LocalDate SuggestedTimeToStartWork;

    private double recommendedPrice;
    private LocalDate dateRegisterOffer;
}
