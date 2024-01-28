package com.example.final_project_2.service.dto;

import com.example.final_project_2.entity.enumaration.ExpertStatus;
import com.example.final_project_2.entity.enumaration.Permission;
import com.example.final_project_2.entity.enumaration.Roll;
import com.example.final_project_2.utill.ValidImage;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ExpertRegisterDto implements Serializable {
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    private String lastName;
    @Column(unique = true)
    @NotBlank
    @Email
    private String email;
    @Column( nullable = false)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8}$")
    private String password;
    private LocalDate dateRegister;
    private Roll roll;
    private Permission permission;
    private ExpertStatus expertStatus;
    private int score;
//    @Lob
//    @ValidImage
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

