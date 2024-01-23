package com.example.final_project_2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Service implements Serializable {
    @Id
    @GeneratedValue
    private String serviceName;
    @ToString.Exclude
    @OneToMany(mappedBy = "service")
    private Set<SubService> subServices = new HashSet<>();

    @Override
    public String toString() {
        return "Service{" +
                ", serviceName='" + serviceName + '\'' +
                "} " ;
    }
}
