package com.example.final_project_2.entity;

import com.example.final_project_2.entity.enumaration.ExpertStatus;
import com.example.final_project_2.entity.enumaration.Permission;
import com.example.final_project_2.entity.enumaration.Roll;
import com.example.final_project_2.utill.ValidImage;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expert extends User {
    @Enumerated(EnumType.STRING)
    private ExpertStatus expertStatus;
    private int score;
    @Lob
    @ValidImage
    private byte[] profileImage;
    @OneToOne
    private Credit credit;
    @ToString.Exclude
    @ManyToMany(mappedBy = "experts")
    private Set<SubService> subServices = new HashSet<>();

//    public Expert(String firstName, int score) {
//        super(firstName);
//        this.score = score;
//    }

    @Override
    public String toString() {
        return "Expert{" +
                super.toString()+
                ", expertStatus=" + expertStatus +
                ", score=" + score +
                "} " ;
    }
}
