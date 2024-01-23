package com.example.final_project_2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubService implements Serializable {
    @Id
    @GeneratedValue
    private String subServiceName;
    private double basePrice;
    private String description;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "subServices_expert",
            joinColumns = @JoinColumn(name = "subService_id"),
            inverseJoinColumns = @JoinColumn(name = "expert_id"))
    private Set<Expert> experts;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Service service;

    @Override
    public String toString() {
        return "SubService{" +
                ", subServiceName='" + subServiceName + '\'' +
                ", basePrice=" + basePrice +
                ", description='" + description + '\'' +
                "} ";
    }
}
