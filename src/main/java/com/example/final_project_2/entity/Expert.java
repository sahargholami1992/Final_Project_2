package com.example.final_project_2.entity;

import com.example.final_project_2.entity.enumaration.ExpertStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expert extends User {
    @Id
    @GeneratedValue
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ExpertStatus expertStatus;
    private int score;
    @Lob
    private byte[] profileImage;
    @OneToOne
    private Credit credit;
    @ToString.Exclude
    @ManyToMany(mappedBy = "experts")
    private Set<SubService> subServices = new HashSet<>();

    @Override
    public String toString() {
        return "Expert{" +
                super.toString()+
                ", expertStatus=" + expertStatus +
                ", score=" + score +
                "} " ;
    }
}
