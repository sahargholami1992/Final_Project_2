package com.example.final_project_2.service.dto;

import com.example.final_project_2.entity.enumaration.StatusOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;
@Getter


public class OrderDto implements Serializable {
    @NotBlank
    private String address;
    @NotNull
    private double recommendedPrice;
    private String description;
    private LocalDate dateDoOrder;
    private StatusOrder statusOrder;

    public OrderDto(String address, double recommendedPrice, String description, LocalDate dateDoOrder) {
        this.address = address;
        this.recommendedPrice = recommendedPrice;
        this.description = description;
        this.dateDoOrder = dateDoOrder;
        this.statusOrder = StatusOrder.WAITING_FOR_EXPERT_SELECTION;
    }
}
