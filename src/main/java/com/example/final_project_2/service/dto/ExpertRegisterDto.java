package com.example.final_project_2.service.dto;

import com.example.final_project_2.entity.enumaration.ExpertStatus;
import com.example.final_project_2.entity.enumaration.Permission;
import com.example.final_project_2.entity.enumaration.Roll;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ExpertRegisterDto implements Serializable {
    private String firstName;
    private String lastName;

    private String email;

    private String password;
    private LocalDate dateRegister;
    private Roll roll;
    private Permission permission;
    private ExpertStatus expertStatus;
    private int score;
    private byte[] profileImage;

    public ExpertRegisterDto(String firstName, String lastName, String email, String password, byte[] profileImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateRegister = LocalDate.now();
        this.roll = Roll.EXPERT;
        this.permission = Permission.WAITING;
        this.expertStatus = ExpertStatus.AWAITING_CONFIRMATION;
        this.score = 0;
        this.profileImage = profileImage;
    }
}

